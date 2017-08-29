package com.xmn.service;


import com.xmn.bean.Customer;
import com.xmn.bean.QueryVo;
import com.xmn.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public Page<Customer> selectPageByQueryVo(QueryVo queryVo);

}
