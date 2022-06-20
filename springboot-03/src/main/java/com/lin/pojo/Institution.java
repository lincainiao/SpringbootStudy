package com.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 部门
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {
    private Integer id;
    private String institutionName;
}
