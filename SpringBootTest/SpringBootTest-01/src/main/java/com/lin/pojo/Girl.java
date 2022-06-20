package com.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Girl {
    private int girlId;
    private String girlName;
    private int age;
    private String job;
}
