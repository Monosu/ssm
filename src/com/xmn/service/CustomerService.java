package com.xmn.service;


import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import com.xmn.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CustomerService {

     Page<Customer> queryPageByQueryVo(QueryVo queryVo);

     void deleteCustomerById(Long id);
}
