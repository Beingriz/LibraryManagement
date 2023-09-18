package com.example.librabymanagementsystem.repository;

import com.example.librabymanagementsystem.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
