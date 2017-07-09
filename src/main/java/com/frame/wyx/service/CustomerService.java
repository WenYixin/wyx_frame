package com.frame.wyx.service;

import com.frame.wyx.helper.DatabaseHelper;
import com.frame.wyx.model.Customer;
import com.frame.wyx.util.PropsUtil;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 34919 on 2017/7/8.
 */
public class CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerService.class);


    public List<Customer> getCustomerList() {
        // TODO
        //to do something
        Connection conn=null;
        try{
            String sql="select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class, sql);
        }catch (Exception e){
            LOGGER.error("execute sql failure",e);
        }finally {
            DatabaseHelper.closeConnection(conn);
            }
        return  null;
    }

    public Customer getCustomer(long userId) {
        // TODO
        return null;
    }

    public boolean createCustomer(Map<String, String> params) {
        // TODO
        return true;
    }

    public boolean updateCustomer(long userId, Map<String, String> params) {
        // TODO
        return true;
    }

    public boolean deleteCustomer(long id) {
        // TODO
        return true;
    }
}
