package com.lin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 员工表
@Data
@NoArgsConstructor
public class Girl {
    private Integer id;
    private String lastName;
    private String nickName;
    private Integer sex;
    private Institution institution;
    private Date birth;

    public Girl(Integer id, String lastName, String nickName, Integer sex, Institution institution) {
        this.id = id;
        this.lastName = lastName;
        this.nickName = nickName;
        this.sex = sex;
        this.institution = institution;
        this.birth = new Date();
    }
}
