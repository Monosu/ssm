package com.xmn.mapper;

import com.xmn.bean.BaseDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class BaseDictMapperTest {

    @Autowired
    private BaseDictMapper baseDictMapper;
    @Test
    public void selectBaseDictListByCode() throws Exception {
        List<BaseDict> baseDicts = baseDictMapper.selectBaseDictListByCode("001");
        System.out.println(baseDicts);
    }

}