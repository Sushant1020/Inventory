package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Product;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {
     List<Product> getAllProducts();
     public boolean addProduct(Product product);

     public boolean deleteProduct(int id);

     public boolean updateProduct(Product product);

     public int gettotalProductnum();

     public Page<Product> getProdNyPaginate(int currentPage, int size);


}
