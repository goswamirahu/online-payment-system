package com.payment.online.paymentsystem.controller;

import com.payment.online.paymentsystem.entity.Transaction;
import com.payment.online.paymentsystem.entity.User;
import com.payment.online.paymentsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        model.addAttribute("transaction", new Transaction()); //
        return "payment"; // payment.html Thymeleaf page
    }


    @PostMapping("/make-payment")
    public String processPayment(@ModelAttribute("transaction") Transaction transaction, Model model) {
        Long userId = 4l;

        User user = new User();
        user.setId(userId);
        transaction.setUser(user);
        transactionService.saveTransaction(transaction);


        model.addAttribute("message", "Payment successful!");

        return "redirect:/transactions"; //
    }

    @GetMapping("/transactions")
    public String showTransactions(Model model) {
        Long userId = 4L; // Temporary, replace with session ID later

        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        model.addAttribute("transactions", transactions);

        return "transactions"; // should match your transactions.html filename
    }
}
