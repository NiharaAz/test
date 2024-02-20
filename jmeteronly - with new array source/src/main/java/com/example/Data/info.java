package com.example.Data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class info {
    String rep_id;
    String person_key;
    String person_value;
    String person_type;
    String person_category;
    String Audit_last_action;
    String Audit_timestamp;
    String src_pax_id;
    String Is_current;


}
