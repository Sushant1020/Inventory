package com.inventory.inventory.ProductRowMapper;

import com.inventory.inventory.Model.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRowMapper implements RowMapper<Purchase> {

    public Purchase mapRow(ResultSet rs,int rownum) throws SQLException{
        Purchase p=new Purchase();
     p.setPurid(rs.getInt(1));
     p.setPurpid(rs.getInt(2));
     p.setPurvid(rs.getInt(3));
     p.setName(rs.getString(4));
     p.setVname(rs.getString(5));
     p.setPqauntity(rs.getInt(6));
     p.setPcostprice(rs.getDouble(7));
     p.setPtotal(rs.getDouble(8));
        return p;
    }

}
