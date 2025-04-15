package com.example.finance.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transaction_tags")
@Data
public class TransactionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
