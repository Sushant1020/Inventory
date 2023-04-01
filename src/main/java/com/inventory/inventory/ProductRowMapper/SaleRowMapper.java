package com.inventory.inventory.ProductRowMapper;

import com.inventory.inventory.Model.Sale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleRowMapper implements RowMapper<Sale> {
    public Sale mapRow(ResultSet rs, int rownum) throws SQLException {
        Sale s=new Sale();
        s.setSaleid(rs.getInt(1));
        s.setSalepid(rs.getInt(2));
        s.setSalecid(rs.getInt(3));
        s.setName(rs.getString(4));
        s.setCname(rs.getString(5));
        s.setSqauntity(rs.getInt(6));
        s.setCsaleprice(rs.getDouble(7));
        s.setStotal(rs.getDouble(8));
        return s;
    }
}
