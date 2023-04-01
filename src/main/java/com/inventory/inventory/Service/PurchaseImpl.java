package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Purchase;
import com.inventory.inventory.Repository.PurchaseRepository;
import com.inventory.inventory.Repository.purrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseImpl implements PurchaseService{

    public PurchaseImpl() {
    }


    @Autowired
    purrepository purrepository;

    public PurchaseImpl(com.inventory.inventory.Repository.purrepository purrepository) {
        this.purrepository = purrepository;
    }

    @Autowired
    PurchaseRepository purchaseRepository;
    @Override
    public boolean addPurchase(Purchase purchase) {
        if(purchaseRepository.addPurchase(purchase))
        return true;
        else return false;
    }

    @Override
    public List<Purchase> findAllPurchase() {
        return purchaseRepository.findAllPurchase();
    }

    @Override
    public int getPurchasenum() {
        return purchaseRepository.getPurchasenum();
    }

    @Override
    public Page<Purchase> getPurNyPaginate(int pageno, int size) {
        Pageable p= PageRequest.of(pageno,size);
        return purrepository.findAll(p);
    }
}
