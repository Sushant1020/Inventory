package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrespository extends JpaRepository<Product,Integer> {
}
