package com.inventory.inventory.ProductRowMapper;

import com.inventory.inventory.Model.Vendor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorRowMapper implements RowMapper<Vendor> {
    public Vendor mapRow(ResultSet rs,int rownum) throws SQLException{
        Vendor v=new Vendor();
        v.setVid(rs.getInt(1));
        v.setVname(rs.getString(2));
        v.setVaddress(rs.getString(3));
        v.setVphone(rs.getString(4));
        v.setVbal(rs.getDouble(5));
        return v;
    }
}
