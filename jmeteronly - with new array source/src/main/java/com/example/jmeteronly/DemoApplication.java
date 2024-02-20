package com.example.jmeteronly;

import com.example.Data.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.springframework.amqp.rabbit.connection.NodeLocator.LOGGER;

@Component
public class DemoApplication {
    RabbitTemplate rabbitTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public DemoApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send_Queue_raceCondition(){
        LOGGER.info("SENDING FIRST MESSAGE PID=1");
        Person p1= settingpaxvalueshere.P1_race();
        Person p2= settingpaxvalueshere.P2_race();
        Person p3= settingpaxvalueshere.P3_race();
        LOGGER.info(String.format("Json message sent -> %s", p1.toString()));
        //this.rabbitTemplate.convertAndSend("QUE.EXT.PAX.DATA.INGEST.NORM", p1);
        LOGGER.info("SENDING FIRST MESSAGE PID=2");
        LOGGER.info(String.format("Json message sent -> %s", p2.toString()));
        //this.rabbitTemplate.convertAndSend("QUE.EXT.PAX.DATA.INGEST.NORM", p2);
        LOGGER.info("SENDING FIRST MESSAGE PID=3");
        LOGGER.info(String.format("Json message sent -> %s", p3.toString()));
       // this.rabbitTemplate.convertAndSend("QUE.EXT.PAX.DATA.INGEST.NORM", p3);
    }
    public void send_Queue_paxingestion()
        {
            //added this
            Person p = settingpaxvalueshere.settingpaxvaluesHere();

         /*   Source s= new Source();
            s.setBookName("bookname_chnaged");
            s.setType("bcbp");
            s.setCarrierCd("SQ");
            s.setBpName("BRADD/pitt");
            s.setFltNum("ft214");
            s.setFltDeptDate("20230909 00:00:00");
            s.setArrPort("SIN");
            s.setDeptPort("FRA");
            s.setFltArrDate("20230909 09:00:00");
            s.setOriginPort("SIN");

            Source s1= new Source();
            //added these 3
            s1.setGender("M");
            s1.setType("ppt");
            s1.setPptNum("s0103");
            s1.setPptName("tst 103 name");
            List<Source> so= new ArrayList<>();
            so.add(s);
            so.add(s1);
            Biographic b= new Biographic();
            b.setAddress("jalan");
            b.setEmail("nih@g");
            b.setNric("987654");

            Source travel = new Source();
            travel.setType("travel");
            travel.setDirection("IN");
            travel.setTravelDatetime("20230908 00:08:05");

            Source entryexit= new Source();
            entryexit.setTerminal("T3");

            so.add(entryexit);so.add(travel);
            Person p = new Person();
            p.setPerson_Id(PersonId);
            p.setSrcType(srcType);
            p.setSrcPaxId(srcPaxID);
            config.setSrcPax_id_validate(p.getSrcPaxId());

            p.setSource(so);
            p.setBiographic(b);*/
            LOGGER.info(String.format("Json message sent -> %s", p.toString()));
            this.rabbitTemplate.convertAndSend("QUE.EXT.PAX.DATA.INGEST.NORM", p);
            System.out.println("rabbit mq sent successfully");
            config.setSrcPax_id_validate(p.getSrcPaxId());

    }


    public void send_Queue_TPT_ingestion(){

        Transport t= settingTransportvalues.settingTRansportobjecthere();

        LOGGER.info(String.format("Json message sent -> %s", t.toString()));
        this.rabbitTemplate.convertAndSend("QUE.EXT.TPT.DATA.INGEST.NORM", t);
        config.setCarrier_cd_validate(t.getSource().get(0).getCarrierCd());
        System.out.println("rabbit mq sent successfully for transport ingestion");
    }


    public void SQL_RACE_CONDITION(){
        String pid_val = "use [pe]\n" +
                "select info.*,rep.src_pax_id, map.Is_current from PERSON_OTHER_INFO info \n" +
                "left join PERSON_REPRESENTATION_MAP map on map.REP_ID=info.REP_ID\n" +
                "left join person person on person.PERSON_ID=map.PERSON_ID\n" +
                "left join REPRESENTATION rep on map.REP_ID=rep.REP_ID\n" +
                "where map.IS_CURRENT=1";
        List<info> pid_info = jdbcTemplate.query(pid_val,BeanPropertyRowMapper.newInstance(info.class));
        for (info i: pid_info){
            if(Objects.equals(i.getPerson_value(), "2")){
                System.out.println("pid is "+i.getPerson_value());
            }
        }
    }
    public void SQL_GET_paxingestion() {

        String sql = "SELECT COUNT(*) FROM PE.DBO.PERSON";
        String sql_rep = "SELECT SRC_PAX_ID FROM PE.DBO.REPRESENTATION";
        String sql_audit_timestamp = "SELECT AUDIT_TIMESTAMP FROM PE.DBO.PERSON";
        LOGGER.info("sending sql");
        LOGGER.info("person validate id is" + config.getSrcPax_id_validate());

        Integer count_ = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count is " + count_);

        String auditTimestamp = jdbcTemplate.queryForObject(sql_audit_timestamp, String.class);
        System.out.println("auditTimestamp is " + auditTimestamp);
        //added this
        String srcPax_id = jdbcTemplate.queryForObject(sql_rep, String.class);
        System.out.println(srcPax_id+ "src pax id is " );
        //List<Representation> representations = jdbcTemplate.query(sql_rep, BeanPropertyRowMapper.newInstance(Representation.class));
       /* representations.stream().filter(x -> Objects.equals(x.getSrcPaxId(), config.getSrcPax_id_validate())).findAny().ifPresentOrElse(value -> System.out.println("Found: " + value.getSrcPaxId()),
                () -> System.out.println("Not found")
        );


        for (Representation k : representations) {
            if (Objects.equals(k.getSrcPaxId(), config.getSrcPax_id_validate())) {
                System.out.println("validated");
            }
        }*/
    }

    public void SQL_GET_transportIngestion() {
        String tpt_sql="SELECT COUNT(*) FROM TRANSPORT.DBO.TRANSPORT";
        String FLT_NUM_sql= "SELECT CARRIER_CD FROM TRANSPORT.DBO.CARRIER_INFO";
        String allsql = "SELECT * FROM TRANSPORT.DBO.CARRIER_INFO";
        //String ArrPort_sql= "SELECT ARR_PORT FROM TRANSPORT.DBO.CARRIER_INFO"
        LOGGER.info("sending sql");
        LOGGER.info(" transport carried cd validate is" + config.getCarrier_cd_validate());

        String carriercd = jdbcTemplate.queryForObject(FLT_NUM_sql, String.class);


        System.out.println("carrier cd is "+ carriercd);
        //System.out.println(carrier_info != null ? carrier_info.getCarrierCd() : null);

        Integer count_ = jdbcTemplate.queryForObject(tpt_sql, Integer.class);

        System.out.println("count is " + count_);
        Source carrier_info = jdbcTemplate.queryForObject(allsql, new BeanPropertyRowMapper<>(Source.class));
        System.out.println("carrier info from bean mapper" +carrier_info.getCarrierCd()+"ArrPort is" +carrier_info.getArrPort()
        +"flight num is " +carrier_info.getFltNum());
        if(Objects.equals(config.getCarrier_cd_validate(), carrier_info.getCarrierCd())){
            System.out.println("carrier cd is same sent in the queue");
        }
        //String ArrPort = jdbcTemplate.queryForObject(ArrPort_sql, String.class);

        //do validation here


    }

}
