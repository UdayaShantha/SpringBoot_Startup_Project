package com.samplesprintbootapp.Project_1.controller;


import com.samplesprintbootapp.Project_1.dto.CustomerDTO;
import com.samplesprintbootapp.Project_1.dto.request.CustomerUpdateDTO;
import com.samplesprintbootapp.Project_1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        System.out.println(customerDTO.getCustomerAddress());
        return customerDTO.toString();

    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String msg=customerService.updateCustomer(customerUpdateDTO);
        return msg;
    }

    @GetMapping(path="/getById",params ="id")
    public CustomerDTO getCustomerById(@RequestParam(value="id") int customerId){
        System.out.println(customerId);
        CustomerDTO customerDTO=customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path="/get-all-customer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> customers=customerService.getAllCustomers();
        return customers;
    }

    @DeleteMapping(path="delete/{id}")
    public String deleteCustomer(@PathVariable("id") int customerId){
        String msg=customerService.deleteCustomer(customerId);
        return msg;
    }

    @GetMapping(path="/getByActive/{active}")
    public List<CustomerDTO> getCustomerByActive(@PathVariable("active") boolean active){
        List<CustomerDTO> customers= customerService.getCustomerByActive(active);
        return customers;
    }
}
