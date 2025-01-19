package com.samplesprintbootapp.Project_1.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Customer")
//@TypeDefs({
//        @TypeDef(name="json",typeClass= JsonType.class)
//})
public class Customer {

    @Id
    @Column(name="customer_id",length =10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name",length =50,nullable = false)
    private String customerName;

    @Column(name="customer_address",length =80)
    private String customerAddress;

//    @Type(type="json")
//    @Column(name="contact_numbers",length =10)
//    private ArrayList contactNumbers;

    @Column(name="contact_numbers",length=50)
    private String contactNumbers;

    @Column(name="customer_salary",nullable = false)
    private double customerSalary;

    @Column(name="nic",length =20)
    private String customerNIC;

    @Column(name="active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;


    public Customer(int customerId, String customerName, String customerAddress, String contactNumbers, double customerSalary, String customerNIC, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumbers = contactNumbers;
        this.customerSalary = customerSalary;
        this.customerNIC = customerNIC;
        this.active = active;
    }

    public Customer() {
    }

    @Override
    public String  toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumbers='" + contactNumbers + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerNIC='" + customerNIC + '\'' +
                ", active=" + active +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
