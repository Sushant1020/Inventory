package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Product;
import com.inventory.inventory.ProductRowMapper.ProductRowMapper;
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
public class ProductRepository {

    Random rand=new Random();
    @Autowired
    JdbcTemplate jdbcTemplate;



    public List<Product> findAll() {
    ArrayList<Product> plist=new ArrayList<>();
        plist.addAll(jdbcTemplate.query("select * from product;",new ProductRowMapper()));

        return plist;
    }


    public boolean addProductfully(Product product){
        String sql="insert into product values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(sql,new PreparedStatementCallback<Boolean>()
        {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                int pid=rand.nextInt(100000);
                ps.setInt(1,pid);
                ps.setString(2,product.getName());
                ps.setString(3,product.getColor());
                ps.setInt(4,0);
                ps.setDouble(5,0);
                ps.setDouble(6,0);
                ps.setDouble(7,0);
                ps.setInt(8,1);
                return ps.execute();
            }
        });
    }

    public boolean deleteProductfully(int id){
        String sql="delete from product where pid="+id;
        jdbcTemplate.execute(sql);
        return true;

    }

    public boolean updateProductfully(Product product) {
        String sql="update product set name=?,color=? where pid="+product.getPid();
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1,product.getName());
                ps.setString(2,product.getColor());
                return ps.execute();
            }
        });
    }

    public int getProductnum() {
        String sql="select sum(qauntity) from product";
        int qauntity=this.jdbcTemplate.queryForObject(sql,Integer.class);
        return qauntity;
    }

}
