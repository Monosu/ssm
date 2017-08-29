package com.xmn.controller;

import com.xmn.bean.BaseDict;
import com.xmn.bean.QueryVo;
import com.xmn.service.BaseDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 客户管理
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Value("${customer.from.type}")
    private String fromTypeCode;
    @Value("${customer.industry.type}")
    private String industryTypeCode;
    @Value("${customer.level.type}")
    private String levelTypeCode;

    @RequestMapping("list" )
    public String list(QueryVo queryVo, Model model){

        if (StringUtils.isNotBlank(queryVo.getCustName())){

        }

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);

        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        return "customer";
    }


}
