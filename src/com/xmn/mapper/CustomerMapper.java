package com.xmn.mapper;

import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    //查总条数
    int queryCountByQueryVo(QueryVo queryVo);
    //查结果集
    List<Customer> queryCustomerListByQueryVo(QueryVo queryVo);

   //删除某条数据
    void deleteCustomerById(Long id);
}
