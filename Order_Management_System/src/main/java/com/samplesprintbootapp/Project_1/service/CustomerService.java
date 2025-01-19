package com.samplesprintbootapp.Project_1.service;


import com.samplesprintbootapp.Project_1.dto.CustomerDTO;
import com.samplesprintbootapp.Project_1.dto.request.CustomerUpdateDTO;
import com.samplesprintbootapp.Project_1.entity.Customer;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDTO CustomerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getCustomerByActive(boolean active);
}
