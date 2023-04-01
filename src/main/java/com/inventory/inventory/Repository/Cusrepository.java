package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cusrepository extends JpaRepository<Customer,Integer> {
}
