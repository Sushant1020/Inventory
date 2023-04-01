package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Purchase;
import com.inventory.inventory.ProductRowMapper.PurchaseRowMapper;
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
public class PurchaseRepository {

    Random rand=new Random();
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean addPurchase(Purchase purchase) {

        String sql3 = "update vendor set vbal=vbal-? where vid=" + purchase.getPurvid()+" and vbal>=?";
        jdbcTemplate.execute(sql3, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setDouble(1, purchase.getPqauntity() * purchase.getPcostprice());
                ps.setDouble(2, purchase.getPqauntity() * purchase.getPcostprice());
                return ps.execute();

            }
        });

            String sql1 = "insert into purchase values(?,?,?,?,?,?,?,?)";
            jdbcTemplate.execute(sql1, new PreparedStatementCallback<Boolean>() {
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    int purid = rand.nextInt(100000);
                    ps.setInt(1, purid);
                    ps.setInt(2, purchase.getPurpid());
                    ps.setInt(3, purchase.getPurvid());
                    ps.setString(4, purchase.getName());
                    ps.setString(5, purchase.getVname());
                    ps.setDouble(6, purchase.getPcostprice());
                    ps.setInt(7, purchase.getPqauntity());
                    ps.setDouble(8, purchase.getPcostprice() * purchase.getPqauntity());
                    return ps.execute();
                }
            });




        String sql="update product set qauntity=qauntity+?,cost=(cost+?)/num,total=total+?,num=num+1 where pid="+purchase.getPurpid();
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,purchase.getPqauntity());
                ps.setDouble(2,purchase.getPcostprice());
                ps.setDouble(3,purchase.getPqauntity()*purchase.getPcostprice());
                return ps.execute();
            }
        });
    }

    public ArrayList<Purchase> findAllPurchase() {
        ArrayList<Purchase> alist=new ArrayList<>();
        alist.addAll(jdbcTemplate.query("select*from purchase",new PurchaseRowMapper()));
        return alist;
    }

    public int getPurchasenum() {
        String sql="select sum(pqauntity) from purchase";
        int pqauntity=this.jdbcTemplate.queryForObject(sql,Integer.class);
        return pqauntity;
    }
}
