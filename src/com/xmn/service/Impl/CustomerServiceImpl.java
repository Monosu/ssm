package com.xmn.service.Impl;

import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import com.xmn.mapper.CustomerMapper;
import com.xmn.service.CustomerService;
import com.xmn.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    //通过四个条件查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo queryVo){
        Page<Customer> page=new Page<Customer>();


        if (queryVo!=null){

            //判断当前页数是否为空
            if (queryVo.getPage()!=null){
                page.setPage(queryVo.getPage());
            }

            if (queryVo.getCustName()!=null&&!queryVo.getCustName().trim().equals("")){
                queryVo.setCustName(queryVo.getCustName().trim());
            }
            if (queryVo.getCustSource()!=null&&!queryVo.getCustSource().trim().equals("")){
                queryVo.setCustSource(queryVo.getCustSource().trim());
            }
            if (queryVo.getCustIndustry()!=null&&!queryVo.getCustIndustry().trim().equals("")){
                queryVo.setCustIndustry(queryVo.getCustIndustry().trim());
            }
            if (queryVo.getCustLevel()!=null&&!queryVo.getCustLevel().trim().equals("")){
                queryVo.setCustLevel(queryVo.getCustLevel().trim());
            }
            Integer count = customerMapper.queryCustomerCountByQueryVo(queryVo);
            page.setTotal(count);
            queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
        }
        List<Customer> list = customerMapper.selectCustomerListByQueryVo(queryVo);
        page.setRows(list);
        //每页显示5条
        page.setSize(5);

        return page;

    }
}
