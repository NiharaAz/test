package com.example.Data;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class Person {

        public Person() {
        }

        String Person_Id;
        String srcPaxId;
        Biographic biographic;
        List<Source> source;
        String srcType;
        String srcLastModifiedDatetime;
        misc misc;
    }
