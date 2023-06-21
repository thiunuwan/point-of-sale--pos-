package com.thiunuwan.pointofsale.service.impl;

import com.thiunuwan.pointofsale.dto.CustomerDTO;
import com.thiunuwan.pointofsale.dto.request.CustomerUpdateDTO;
import com.thiunuwan.pointofsale.entity.Customer;
import com.thiunuwan.pointofsale.repository.CustomerRepository;
import com.thiunuwan.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDTO customer) {
        Customer customer1 =new Customer();


        return customerRepository.save(customer1).getCustomerName();
    }

    @Override
    public String UpdateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if(customerRepository.existsById(customerUpdateDTO.getCustomerId())){
           Customer customer= customerRepository.getById(customerUpdateDTO.getCustomerId());
           customer.setCustomerName(customerUpdateDTO.getCustomerName());
           customerRepository.saveAndFlush(customer);
           return "updated";
        }else{
          throw new RuntimeException("no data");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepository.existsById(customerId)){
            Customer customer=customerRepository.getById(customerId);
            CustomerDTO customerDTO=null;
            return null;
        }else {
            throw new RuntimeException("no customer");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList =new ArrayList<>();

        for (Customer customer:customerList) {
            customerDTOList.add(new CustomerDTO());
        }

        return customerDTOList ;
    }

    @Override
    public String deleteCustomer(int id) {
        if(customerRepository.existsById(id)){
          customerRepository.deleteById(id);
          return "deleted";
        }else{
            throw new RuntimeException("exception-no customer found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean state) {
        List<Customer> customerList = customerRepository.findAllByActiveEquals(state);
        List<CustomerDTO> customerDTOList =new ArrayList<>();

        for (Customer customer:customerList) {
            customerDTOList.add(new CustomerDTO());
        }

        return customerDTOList ;
    }


}
