package com.lin.dao;

import com.lin.pojo.Institution;
import com.lin.pojo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工
@Repository
public class GirlMapper {
    // 员工有所属的部门
//    @Autowired
    private static InstitutionMapper institutionMapper;
    // 模拟数据库中的数据
    private static Map<Integer, Girl> girlMap = null;
    static {
        institutionMapper = new InstitutionMapper();
        girlMap = new HashMap<>();
        girlMap.put(1001,new Girl(1001,"zhizhi","zhizhi",0,institutionMapper.getInstitutionById(101)));
        girlMap.put(1002,new Girl(1002,"ytm","ytm",0,institutionMapper.getInstitutionById(102)));
        girlMap.put(1003,new Girl(1003,"zsy","zsy",0,institutionMapper.getInstitutionById(103)));
        girlMap.put(1004,new Girl(1004,"wxy","wxy",0,institutionMapper.getInstitutionById(104)));
        girlMap.put(1005,new Girl(1005,"mxy","mxy",0,institutionMapper.getInstitutionById(105)));
        if (institutionMapper == null) {
            System.out.println("GirlMapper's institution is null");
        }
    }

    // 增加员工
    private static Integer initId = 1006;
    public void add(Girl girl){
        if (girl.getId() == null){
            girl.setId(initId++);
        }
        girl.setInstitution(institutionMapper.getInstitutionById(girl.getInstitution().getId()));
        girlMap.put(girl.getId(), girl);
    }

    // 查询全部员工
    public Collection<Girl> getGirls(){
        return girlMap.values();
    }

    // 通过Id查询员工
    public Girl getGirlById(Integer id){
        return girlMap.get(id);
    }

    // 删除员工
    public void deleteGirlById(Integer id){
        girlMap.remove(id);
    }
}
