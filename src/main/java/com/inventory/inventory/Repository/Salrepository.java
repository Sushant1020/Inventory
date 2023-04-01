package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Salrepository extends JpaRepository<Sale,Integer> {
}
