package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Purchase;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PurchaseService {

    public boolean addPurchase(Purchase purchase);

    List<Purchase> findAllPurchase();

    public int getPurchasenum();

    Page<Purchase> getPurNyPaginate(int pageno, int size);
}
