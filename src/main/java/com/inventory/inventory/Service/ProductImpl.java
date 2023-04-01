package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Product;
import com.inventory.inventory.Repository.ProductRepository;
import com.inventory.inventory.Repository.Productrespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements  ProductService{

    @Autowired
    Productrespository productrepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean addProduct(Product product) {
        if(productRepository.addProductfully(product))
        return true;
        else
            return false;
    }

    public boolean deleteProduct(int id){
    if(productRepository.deleteProductfully(id))
        return true;
        else
            return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProductfully(product);
    }

    @Override
    public int gettotalProductnum() {
        return productRepository.getProductnum();
    }

    public Page<Product> getProdNyPaginate(int currentPage, int size){
        Pageable p= PageRequest.of(currentPage,size);
        return productrepository.findAll(p);
    }

}
