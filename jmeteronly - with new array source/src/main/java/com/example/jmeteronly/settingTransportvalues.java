package com.example.jmeteronly;

import com.example.Data.Source;
import com.example.Data.Transport;

import java.util.ArrayList;
import java.util.List;

//19-02-2024
public class settingTransportvalues {
    static Transport settingTRansportobjecthere(){
        Transport t= new Transport();

        t.setSrcType("DAS");
        t.setSrcFltId("C1234");
        t.setSrcStatus("I");

        Source entryexit= new Source();
        entryexit.setBaggageUnit("22");
        entryexit.setTerminal("T2");
        entryexit.setGate("A1");
        entryexit.setEntryPoint("AIR");
        entryexit.setExitPoint("");
        entryexit.setType("entryExit");

        Source travel=new Source();
        travel.setDirection("IN");
        travel.setType("travel");
        travel.setTravelDatetime("20230909 00:00:00");
        travel.setVehicleNum("S34234");
        travel.setVehicleSubType("AC");

        Source bcbp = new Source();
        bcbp.setBookName("bookname1");
        bcbp.setType("bcbp");
        bcbp.setCarrierCd("2PA");
        bcbp.setArrPort("SIN");
        bcbp.setDeptPort("FRA");
        bcbp.setOriginPort("SIN");
        bcbp.setFltNum("TKLUX95ZOA4RXWN");
        bcbp.setUpdatedFltArrDate("20230914 00:04:02");
        bcbp.setFltArrDate("20230125 17:18:04");
        bcbp.setTravelDatetime("20240218 00:00:00");
        bcbp.setOriginDate("20270909");
        bcbp.setFltDeptDate("20070708 07:00:00");
        bcbp.setBpName("BRAD/PIt");

        List<Source> source_list = new ArrayList<>();
        source_list.add(bcbp);
        source_list.add(travel);
        source_list.add(entryexit);

        t.setSource(source_list);
        return t;
    }
}
