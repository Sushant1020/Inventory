package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Vendor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VendorService {

    public boolean addVendor(Vendor vendor);

    List<Vendor> getAllVendors();

    public boolean deleteVendor(int id);

    public boolean updateVendor(Vendor vendor);

    public Page<Vendor> getVenNyPaginate(int currentPage, int size);
}
