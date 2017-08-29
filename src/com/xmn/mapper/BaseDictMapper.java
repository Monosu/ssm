package com.xmn.mapper;

import com.xmn.bean.BaseDict;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("baseDictMapper")
public interface BaseDictMapper {

    //查询
     List<BaseDict> selectBaseDictListByCode(String code);
}
