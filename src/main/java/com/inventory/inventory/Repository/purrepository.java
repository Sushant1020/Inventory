package com.inventory.inventory.Repository;

import com.inventory.inventory.Model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface purrepository extends JpaRepository<Purchase,Integer> {
}
