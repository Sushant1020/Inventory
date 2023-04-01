package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Vendor;
import com.inventory.inventory.ProductRowMapper.VendorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class VendorRepository{
    Random rand=new Random();
        @Autowired
    JdbcTemplate jdbcTemplate;

        public Boolean addVendorfully(Vendor vendor){
            String sql="insert into vendor values(?,?,?,?,?)";
            return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
                int vid=rand.nextInt(10000,100000);
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setInt(1,vid);
                    ps.setString(2,vendor.getVname());
                    ps.setString(3,vendor.getVaddress());
                    ps.setString(4,vendor.getVphone());
                    ps.setDouble(5,vendor.getVbal());
                    return ps.execute();
                }
            });
        }

    public List<Vendor> findAllVendors() {
        ArrayList<Vendor> vlist=new ArrayList<>();
        vlist.addAll(jdbcTemplate.query("select * from vendor;",new VendorRowMapper()));

        return vlist;
    }

    public boolean deleteVendor(int id) {
            String sql="delete from vendor where vid="+id;
            jdbcTemplate.execute(sql);
            return true;
    }

    public boolean updateVendor(Vendor vendor) {
            String sql="update vendor set vid=?,vname=?,vaddress=?,vphone=?,vbal=vbal+? where vid="+vendor.getVid();
            return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setInt(1,vendor.getVid());
                    ps.setString(2,vendor.getVname());
                    ps.setString(3,vendor.getVaddress());
                    ps.setString(4,vendor.getVphone());
                    ps.setDouble(5,vendor.getVbal());
                    return ps.execute();
                }
            });
    }
}
