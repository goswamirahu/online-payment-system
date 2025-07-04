package com.payment.online.paymentsystem.controller;

import com.payment.online.paymentsystem.entity.Transaction;
import com.payment.online.paymentsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionViewController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")  // ye URL hit hoga Thymeleaf ke liye
    public String showTransactions(Model model) {
        Long userId = 4L;  // hardcoded for now
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        model.addAttribute("transactions", transactions);
        return "transactions";  // ye load karega transactions.html
    }
}
