package com.example.Data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Source {
    String type;
    String gender;

    String bookName;
    String carrierCd;
    String arrPort;
    String bpName;
    String deptPort;
    String fltArrDate;
    String fltDeptDate;
    String fltNum;
    String originDate;
    String originPort;
    String updatedFltArrDate;

    //ppt
    String pptName;
    String pptNum;
    String natCd;

    //entryexit
    String entryPoint;
    String exitPoint;
    String baggageUnit;
    String gate;
    String terminal;

    //travel
    String vehicleNum;
    String vehicleSubType;
    String direction;
    String travelDatetime;

}
