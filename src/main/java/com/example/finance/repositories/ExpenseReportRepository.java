package com.example.finance.repositories;

import com.example.finance.models.ExpenseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseReportRepository extends JpaRepository<ExpenseReport, Long> {
    List<ExpenseReport> findByUserIdAndYear(Long userId, int year);
}
