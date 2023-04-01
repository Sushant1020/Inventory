package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Sale;
import com.inventory.inventory.Repository.SaleRepository;
import com.inventory.inventory.Repository.Salrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleImpl implements SaleService{

    @Autowired
    Salrepository salrepository;

    public SaleImpl(Salrepository salrepository) {
        this.salrepository = salrepository;
    }

    @Autowired
    SaleRepository saleRepository;

    @Override
    public boolean addSales(Sale sale) {
        return saleRepository.addSale(sale);
    }

    @Override
    public List<Sale> findAllSale() {
        return saleRepository.findAllSale();
    }

    @Override
    public double getProft() {
        return saleRepository.getProfit();
    }

    @Override
    public double getProfitPer() {
        return saleRepository.getProfitper();
    }

    @Override
    public Page<Sale> getSaleNyPaginate(int currentPage, int size) {
        Pageable p= PageRequest.of(currentPage,size);
        return salrepository.findAll(p);
    }

}
