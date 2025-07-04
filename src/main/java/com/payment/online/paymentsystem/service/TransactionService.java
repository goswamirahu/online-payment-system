package com.payment.online.paymentsystem.service;

import com.payment.online.paymentsystem.entity.Transaction;
import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getTransactionsByUserId(Long userId);
}
