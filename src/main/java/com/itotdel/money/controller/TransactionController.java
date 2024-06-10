package com.itotdel.money.controller;


import com.itotdel.money.exception.NoDateProvidedException;
import com.itotdel.money.model.AddTransactionRequest;
import com.itotdel.money.model.MessageResponse;
import com.itotdel.money.model.Transaction;
import com.itotdel.money.model.TransactionView;
import com.itotdel.money.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ExceptionHandler(NoDateProvidedException.class)
    ResponseEntity<MessageResponse> handleNoDateProvidedException(NoDateProvidedException ex) {
        MessageResponse response = new MessageResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping()
    ResponseEntity<Transaction> addTransaction(@RequestBody AddTransactionRequest body) {
        return ResponseEntity.ok(transactionService.addTransaction(body));

//        transactionService.addTransaction(body);
//        ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<Optional<List<TransactionView>>> getTransactions(@RequestParam String userId,
                                                                   @RequestParam(required = false) Date date,
                                                                   @RequestParam(required = false) Date startDate,
                                                                   @RequestParam(required = false) Date endDate) {
        return ResponseEntity.ok(transactionService.getTransactions(userId, date, startDate, endDate));
    }
}
