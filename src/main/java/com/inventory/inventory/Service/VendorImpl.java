package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Vendor;
import com.inventory.inventory.Repository.VendorRepository;
import com.inventory.inventory.Repository.Venrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorImpl implements VendorService{

    @Autowired
    Venrepository venrepository;

    public VendorImpl(Venrepository venrepository) {
        this.venrepository = venrepository;
    }

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public boolean addVendor(Vendor vendor) {
        if(vendorRepository.addVendorfully(vendor))
        return true;
        else return false;
    }

    @Override
    public List<Vendor> getAllVendors() {

        return vendorRepository.findAllVendors();
    }

    @Override
    public boolean deleteVendor(int id) {
        return vendorRepository.deleteVendor(id);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        if(vendorRepository.updateVendor(vendor)){
            return true;
        }
        else return false;
    }

    @Override
    public Page<Vendor> getVenNyPaginate(int currentPage, int size) {
        Pageable p= PageRequest.of(currentPage,size);
        return venrepository.findAll(p);
    }
}
