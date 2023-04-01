package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Sale;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SaleService {

    public boolean addSales(Sale sale);

    List<Sale> findAllSale();

    public double getProft();

    public double getProfitPer();

    public Page<Sale> getSaleNyPaginate(int currentPage, int size);

}
