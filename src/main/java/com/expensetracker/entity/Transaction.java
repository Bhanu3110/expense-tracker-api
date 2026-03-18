package com.expensetracker.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String type;
    private String category;
    private String description;
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Link transaction to a user
}