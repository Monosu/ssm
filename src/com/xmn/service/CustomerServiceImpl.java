package com.xmn.service;

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

    @Override
    public Page<Customer> queryPageByQueryVo(QueryVo queryVo) {

        //设置查询条件,设置从哪条数据开始查
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());

        //查询数据结果集
        List<Customer> customerList = customerMapper.queryCustomerListByQueryVo(queryVo);
        //查询数据的总条数
        int total = customerMapper.queryCountByQueryVo(queryVo);

        //封装返回的page对象
        Page<Customer> page=new Page<Customer>();
        page.setTotal(total);
        page.setPage(queryVo.getPage());//当前第几页
        page.setSize(queryVo.getRows());//设置每页显示几条
        page.setRows(customerList);

        return page;
    }
}
