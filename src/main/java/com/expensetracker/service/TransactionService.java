package com.expensetracker.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.expensetracker.entity.Transaction;
import com.expensetracker.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public Page<Transaction> getTransactionsByUser(Long userId, int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isEmpty()) {
            return repository.findByUserIdAndCategoryContainingIgnoreCase(userId, search, pageable);
        }
        return repository.findByUserId(userId, pageable);
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}