package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Sale;
import com.inventory.inventory.ProductRowMapper.SaleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

@Repository
public class SaleRepository {

    Random rand=new Random();
    @Autowired
    JdbcTemplate jdbcTemplate;




    public boolean addSale(Sale sale) {
        System.out.print(sale);

        String sql3 = "update customer set cbal=cbal-? where cid=" + sale.getSalecid()+" and cbal>=?";
        jdbcTemplate.execute(sql3, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setDouble(1, sale.getSqauntity() * sale.getCsaleprice());
                ps.setDouble(2, sale.getSqauntity() * sale.getCsaleprice());
                return ps.execute();

            }
        });

        String sql2="update product set qauntity=qauntity-?,total=total-? where pid="+sale.getSalepid();
        jdbcTemplate.execute(sql2, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,sale.getSqauntity());
                ps.setDouble(2,sale.getSqauntity()*sale.getCsaleprice());
                return ps.execute();
            }
        });


        String sql="insert into sale values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            int saleid=rand.nextInt(10000,100000);
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,saleid);
                ps.setInt(2,sale.getSalepid());
                ps.setInt(3,sale.getSalecid());
                ps.setString(4,sale.getName());
                ps.setString(5,sale.getCname());
                ps.setInt(6,sale.getSqauntity());
                ps.setDouble(7,sale.getCsaleprice());
                ps.setDouble(8,sale.getCsaleprice()*sale.getSqauntity());
                return ps.execute();
            }
        });



    }
    public ArrayList<Sale> findAllSale() {
        ArrayList<Sale> alist=new ArrayList<>();
        alist.addAll(jdbcTemplate.query("select*from sale",new SaleRowMapper()));
        return alist;
    }

    public double getProfit() {
        String sql="select sum(ptotal) from purchase";
        double ptotal=this.jdbcTemplate.queryForObject(sql, Double.class);
        String sql1="select sum(stotal) from sale";
        double stotal=this.jdbcTemplate.queryForObject(sql1, Double.class);
        double total=stotal-ptotal;
        return  total;
    }

    public double getProfitper() {
        String sql="select sum(ptotal) from purchase";
        double ptotal=this.jdbcTemplate.queryForObject(sql, Double.class);
        String sql1="select sum(stotal) from sale";
        double stotal=this.jdbcTemplate.queryForObject(sql1, Double.class);
        double total=stotal-ptotal;
        double percent=total/ptotal;
        percent=Math.ceil(percent);
        return percent;
    }
}
