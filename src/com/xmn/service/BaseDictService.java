package com.xmn.service;

import com.xmn.bean.BaseDict;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseDictService {

    List<BaseDict> selectBaseDictListByCode(String code);
}
