package com.xmn.mapper;

import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    //总条数
    public Integer queryCustomerCountByQueryVo(QueryVo queryVo);
    //结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo queryVo);
}
