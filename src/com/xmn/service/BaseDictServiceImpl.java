package com.xmn.service;


import com.xmn.bean.BaseDict;
import com.xmn.mapper.BaseDictMapper;
import com.xmn.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;



    @Override
    public List<BaseDict> selectBaseDictListByCode(String code) {

        return baseDictMapper.selectBaseDictListByCode(code);
    }


}
