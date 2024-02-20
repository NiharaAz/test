package com.example.Data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
public class Transport {
    String srcType="DAS";
    List<Source> source;
    String srcFltId="C1234";
    String srcStatus="I";
    String srcCreatedDatetime="20020515 00:00:00";
    String srcLastModifiedDatetime= "20230909 09:00:00";

}
