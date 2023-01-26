package com.LMSbackend.LMS_backendApplication.Controllers;

import com.LMSbackend.LMS_backendApplication.Models.Transaction;
import com.LMSbackend.LMS_backendApplication.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        String externalTransactionId = transactionService.issueBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransactionId, HttpStatus.ACCEPTED);
    }

    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        Transaction externalTransaction = transactionService.returnBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed, here is your transactionId - " + externalTransaction.getTransactionId(), HttpStatus.ACCEPTED);
    }
}
