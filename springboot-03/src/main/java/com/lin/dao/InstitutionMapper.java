package com.lin.dao;

import com.lin.pojo.Institution;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InstitutionMapper {
    // 模拟数据库中的数据
    private static Map<Integer, Institution> institutionMap = null;
    static {
        institutionMap = new HashMap<>();
        institutionMap.put(101,new Institution(101,"立青1"));
        institutionMap.put(102,new Institution(102,"立青2"));
        institutionMap.put(103,new Institution(103,"画语1"));
        institutionMap.put(104,new Institution(104,"画语2"));
        institutionMap.put(105,new Institution(105,"MG"));
    }

    // 获得所有部门信息
    public Collection<Institution> getInstitutions(){
        return institutionMap.values();
    }

    // 通过id获得部门信息
    public Institution getInstitutionById(Integer id){
        return institutionMap.get(id);
    }

}
