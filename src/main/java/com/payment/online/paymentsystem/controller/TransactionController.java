package com.payment.online.paymentsystem.controller;

import com.payment.online.paymentsystem.entity.Transaction;
import com.payment.online.paymentsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/pay")
    public String makePayment(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "Payment successful!";
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactions(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }
}
