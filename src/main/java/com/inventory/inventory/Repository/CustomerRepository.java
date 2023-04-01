package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Customer;
import com.inventory.inventory.ProductRowMapper.CustomerRowMapper;
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
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    Random rand=new Random();
    public boolean addCustomer(Customer customer){
        String sql="insert into customer values(?,?,?,?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                int cid= rand.nextInt(10000,100000);
                ps.setInt(1,cid);
                ps.setString(2,customer.getCname());
                ps.setString(3,customer.getCaddress());
                ps.setString(4,customer.getCphone());
                ps.setDouble(5,customer.getCbal());
                return ps.execute();
            }
        });
    }

    public List<Customer> findAllCustomers() {
        String sql="select*from customer";
        ArrayList<Customer> clist=new ArrayList<>();
        clist.addAll(jdbcTemplate.query("select*from customer",new CustomerRowMapper()));
        return clist;
    }

    public boolean deleteCustomer(int id) {
        String sql="delete from customer where cid="+id;
        jdbcTemplate.execute(sql);
            return true;
        }

    public boolean updateCustomer(Customer customer) {
        String sql="update customer set cid=?,cname=?,caddress=?,cphone=?,cbal=cbal+? where cid="+customer.getCid();
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,customer.getCid());
                ps.setString(2,customer.getCname());
                ps.setString(3,customer.getCaddress());
                ps.setString(4,customer.getCphone());
                ps.setDouble(5,customer.getCbal());
                return ps.execute();
            }
        });
    }
}
