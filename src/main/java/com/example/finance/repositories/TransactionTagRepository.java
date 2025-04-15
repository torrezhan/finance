package com.example.finance.repositories;

import com.example.finance.models.TransactionTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTagRepository extends JpaRepository<TransactionTag, Long> {
}
