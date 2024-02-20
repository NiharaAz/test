package com.example.jmeteronly;

import com.example.Data.Biographic;
import com.example.Data.Person;
import com.example.Data.Source;
import com.example.Data.misc;

import java.util.ArrayList;
import java.util.List;

public class settingpaxvalueshere {
    static Person P1_race(){
        Person p1= new Person();
        p1.setSrcPaxId("S01");
        p1.setSrcType("SGAC");
        Source s1= new Source();
        s1.setType("bcbp");
        s1.setArrPort("KEN");
        s1.setDeptPort("SIN");
        s1.setFltNum("flight01");
        s1.setCarrierCd("C01");
        s1.setOriginPort("SIN");

        Source s2= new Source();
        s2.setType("ppt");
        s2.setPptName("ppt1");
        s2.setPptNum("pptnum1");

        List<Source>list_source = new ArrayList<>();
        list_source.add(s1);list_source.add(s2);
        p1.setSource(list_source);
        p1.setSrcLastModifiedDatetime("20230909 00:00:00");
        misc misc = new misc();
        misc.setPid("1");
        p1.setMisc(misc);
        return p1;
    }
    static Person P2_race() {
        Person p2= new Person();
        p2.setSrcPaxId("S01");
        p2.setSrcType("SGAC");
        Source s1= new Source();
        s1.setType("bcbp");
        s1.setArrPort("KEN");
        s1.setDeptPort("SIN");
        s1.setFltNum("flight01");
        s1.setCarrierCd("C01");
        s1.setOriginPort("SIN");

        Source s2= new Source();
        s2.setType("ppt");
        s2.setPptName("ppt1");
        s2.setPptNum("pptnum1");

        List<Source>list_source = new ArrayList<>();
        list_source.add(s1);list_source.add(s2);
        p2.setSource(list_source);
        p2.setSrcLastModifiedDatetime("20230909 01:00:00");

        misc misc2 = new misc();
        misc2.setPid("2");
        p2.setMisc(misc2);
        return p2;
    }

    static Person P3_race() {
        Person p3= new Person();
        p3.setSrcPaxId("S01");
        p3.setSrcType("SGAC");
        Source s1= new Source();
        s1.setType("bcbp");
        s1.setArrPort("KEN");
        s1.setDeptPort("SIN");
        s1.setFltNum("flight01");
        s1.setCarrierCd("C01");
        s1.setOriginPort("SIN");

        Source s2= new Source();
        s2.setType("ppt");
        s2.setPptName("ppt1");
        s2.setPptNum("pptnum1");

        List<Source>list_source = new ArrayList<>();
        list_source.add(s1);list_source.add(s2);
        p3.setSource(list_source);
        p3.setSrcLastModifiedDatetime("20230909 02:00:00");
        misc misc3 = new misc();
        misc3.setPid("3");
        p3.setMisc(misc3);
        return p3;
    }

    static Person settingpaxvaluesHere(){
        Source s= new Source();
        s.setBookName("bookname_chnaged");
        s.setType("bcbp");
        s.setCarrierCd("2PA");
        s.setBpName("BRADD/pitt");
        s.setFltNum("TKLUX95ZOA4RXWN");
        s.setFltDeptDate("20070708 07:00:00");
        s.setArrPort("SIN");
        s.setDeptPort("FRA");
        s.setFltArrDate("20230125 17:18:04");
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

        Person p = new Person();
        p.setPerson_Id("pax214");
        p.setSrcType("SGAC");
        p.setSrcPaxId("RXA3264MUE");

        p.setSource(so);
        p.setBiographic(b);
        p.setSrcLastModifiedDatetime("20230909 00:00:00");

        return p;
    }

}
