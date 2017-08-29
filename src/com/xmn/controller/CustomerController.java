package com.xmn.controller;

import com.xmn.bean.BaseDict;
import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import com.xmn.service.BaseDictService;
import com.xmn.service.CustomerService;
import com.xmn.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 客户管理
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value("${customer.from.type}")
    private String fromTypeCode;
    @Value("${customer.industry.type}")
    private String industryTypeCode;
    @Value("${customer.level.type}")
    private String levelTypeCode;

    @RequestMapping("list" )
    public String queryCustomerList(QueryVo queryVo, Model model){

        try {
            //解决get提交的乱码问题
            if (StringUtils.isNotBlank(queryVo.getCustName())){
                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"),"UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);

        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        Page<Customer> page = customerService.queryPageByQueryVo(queryVo);
        model.addAttribute("page",page);

        //数据回显
        model.addAttribute("custName",queryVo.getCustName());
        model.addAttribute("custSource",queryVo.getCustSource());
        model.addAttribute("custIndustry",queryVo.getCustIndustry());
        model.addAttribute("custLevel",queryVo.getCustLevel());

        return "customer";
    }


}
