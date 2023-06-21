package com.thiunuwan.pointofsale.controller;


import com.thiunuwan.pointofsale.dto.CustomerDTO;
import com.thiunuwan.pointofsale.dto.request.CustomerUpdateDTO;
import com.thiunuwan.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestBody CustomerDTO customer){

    return customerService.saveCustomer(customer);
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO, @PathVariable int id){

         customerService.UpdateCustomer(customerUpdateDTO);
         return "updated";
    }


    @GetMapping(path = "/get-by-id/",params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){

        return  customerService.getCustomerById(customerId);
    }


    @GetMapping("/get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable int id){

        return customerService.deleteCustomer(id);
    }


    @GetMapping("/get-all-customers-by-active-state/{state}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable boolean state){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(state);
        return allCustomers;
    }





}
