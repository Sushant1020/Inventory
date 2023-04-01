package com.inventory.inventory.ProductRowMapper;

import com.inventory.inventory.Model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
    public Customer mapRow(ResultSet rs,int rownum) throws SQLException{
        Customer c=new Customer();
        c.setCid(rs.getInt(1));
        c.setCname(rs.getString(2));
        c.setCaddress(rs.getString(3));
        c.setCphone(rs.getString(4));
        c.setCbal(rs.getDouble(5));
        return c;
    }
}
