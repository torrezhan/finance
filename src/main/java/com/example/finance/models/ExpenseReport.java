package com.example.finance.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "expense_reports")
@Data
public class ExpenseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private Double totalExpense;
}
