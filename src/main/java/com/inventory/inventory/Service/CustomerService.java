package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CustomerService {
    public boolean addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    public boolean deleteCustomer(int id);

    public boolean updateCustomer(Customer customer);

    public Page<Customer> getCusNyPaginate(int currentPage, int size);
}
