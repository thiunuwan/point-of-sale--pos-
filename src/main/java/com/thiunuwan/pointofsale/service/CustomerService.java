package com.thiunuwan.pointofsale.service;

import com.thiunuwan.pointofsale.dto.CustomerDTO;
import com.thiunuwan.pointofsale.dto.request.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    String saveCustomer(CustomerDTO customer);

    String UpdateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int id);

    List<CustomerDTO> getAllCustomersByActiveState(boolean state);
}
