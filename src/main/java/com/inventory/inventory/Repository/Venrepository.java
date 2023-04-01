package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Venrepository extends JpaRepository<Vendor,Integer> {
}
