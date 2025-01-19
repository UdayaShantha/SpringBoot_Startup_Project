package com.samplesprintbootapp.Project_1.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String contactNumbers;
    private double customerSalary;
    private String customerNIC;
    private boolean active;

    public CustomerDTO(int customerId, String customerName, String customerAddress, String contactNumbers, String customerNIC, boolean active, double customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumbers = contactNumbers;
        this.customerNIC = customerNIC;
        this.active = active;
        this.customerSalary = customerSalary;
    }

    public CustomerDTO() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(String contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
