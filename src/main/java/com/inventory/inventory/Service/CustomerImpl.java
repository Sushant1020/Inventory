package com.inventory.inventory.Service;

import com.inventory.inventory.Model.Customer;
import com.inventory.inventory.Repository.Cusrepository;
import com.inventory.inventory.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerImpl implements CustomerService {

    public CustomerImpl() {
    }

    @Autowired
    Cusrepository cusrepository;

    public CustomerImpl(Cusrepository cusrepository) {
        this.cusrepository = cusrepository;
    }

    @Autowired
    CustomerRepository customerRepository;

    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customerRepository.addCustomer(customer))
        return true;
        else return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepository.deleteCustomer(id))
        return true;
        else return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }



    @Override
    public Page<Customer> getCusNyPaginate(int currentPage, int size) {
        Pageable p= PageRequest.of(currentPage,size);
        return cusrepository.findAll(p);
    }

}
