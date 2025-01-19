package com.samplesprintbootapp.Project_1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="orders-table")
public class Order {

    @Id
    @Column(name="order_id",length=30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

}
