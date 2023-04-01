package com.inventory.inventory.ProductRowMapper;

import com.inventory.inventory.Model.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class ProductRowMapper implements RowMapper<Product> {
   public Product mapRow(ResultSet rs,int rownum) throws SQLException{
       Product p=new Product();
       p.setPid(rs.getInt(1));
       p.setName(rs.getString(2));
       p.setColor(rs.getString(3));
       p.setQauntity(rs.getInt(4));
       p.setCost(rs.getDouble(5));
       p.setSellprice(rs.getDouble(6));
       p.setTotal(rs.getDouble(7));
       p.setNum(rs.getInt(8));

       return p;
   }

}
