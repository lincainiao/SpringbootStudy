package com.lin.service;

import com.lin.dao.InstitutionMapper;
import com.lin.pojo.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class InstitutionService {
//    @Autowired
    static InstitutionMapper institutionMapper;
    static{
        institutionMapper = new InstitutionMapper();
    }
    public Collection<Institution> getInstitutions(){
        return institutionMapper.getInstitutions();
    }
}
