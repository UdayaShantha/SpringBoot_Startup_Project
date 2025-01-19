package com.samplesprintbootapp.Project_1.service.impl;

import com.samplesprintbootapp.Project_1.dto.CustomerDTO;
import com.samplesprintbootapp.Project_1.dto.request.CustomerUpdateDTO;
import com.samplesprintbootapp.Project_1.entity.Customer;
import com.samplesprintbootapp.Project_1.exception.NotFoundexception;
import com.samplesprintbootapp.Project_1.repo.CustomerRepo;
import com.samplesprintbootapp.Project_1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        System.out.println(customerDTO.getCustomerAddress());
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumbers(),
                customerDTO.getCustomerSalary(),
                customerDTO.getCustomerNIC(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.toString();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO){
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.findById(customerUpdateDTO.getCustomerId()).get();

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName()+" Updated Successfully";
        }else{
            return null;
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.findById(customerId).get();
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerNIC(),
                    customer.isActive(),
                    customer.getCustomerSalary()
            );
            return customerDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        if(!customers.isEmpty()) {
            List<CustomerDTO> customerDTOs = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactNumbers(),
                        customer.getCustomerNIC(),
                        customer.isActive(),
                        customer.getCustomerSalary()
                );
                customerDTOs.add(customerDTO);
            }
            return customerDTOs;
        }else{
            throw new NotFoundexception("Customer list is empty");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted Successfully";
        }
        else{
            return "Customer Not Found";
        }
    }

    @Override
    public List<CustomerDTO> getCustomerByActive(boolean active) {
            List<Customer> customers = customerRepo.findAllByActiveEquals(active);
            List<CustomerDTO> customerDTOs = new ArrayList<>();
            for(Customer customer : customers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactNumbers(),
                        customer.getCustomerNIC(),
                        customer.isActive(),
                        customer.getCustomerSalary()
                );
                customerDTOs.add(customerDTO);
            }
            return customerDTOs;

    }
}
