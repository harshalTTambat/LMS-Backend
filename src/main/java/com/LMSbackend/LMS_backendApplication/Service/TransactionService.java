package com.LMSbackend.LMS_backendApplication.Service;

import com.LMSbackend.LMS_backendApplication.Enums.CardStatus;
import com.LMSbackend.LMS_backendApplication.Enums.TransactionStatus;
import com.LMSbackend.LMS_backendApplication.Models.Book;
import com.LMSbackend.LMS_backendApplication.Models.Card;
import com.LMSbackend.LMS_backendApplication.Models.Transaction;
import com.LMSbackend.LMS_backendApplication.Repository.BookRepository;
import com.LMSbackend.LMS_backendApplication.Repository.CardRepository;
import com.LMSbackend.LMS_backendApplication.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service
public class TransactionService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${books.max_allowed}")
    public
    int max_allowed_books;

    @Value("${books.max_allowed_days}")
    public
    int getMax_allowed_days;

    @Value("${books.fine.per_day}")
    public
    int fine_per_day;

    public String issueBook(int cardId, int bookId) throws Exception {
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);

        //Book should be available
        if(book == null || !book.isAvailable()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is either unavailable or not present");
        }

        //Card is unavaible or its deactivated
        if(card == null || card.getCardStatus().equals(CardStatus.DEACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is invalid");
        }

        if(card.getBooks().size() >= max_allowed_books){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book limit has reached for this card");
        }

        book.setCard(card);
        book.setAvailable(false);
        List<Book> bookList = card.getBooks();
        bookList.add(book);
        card.setBooks(bookList);

        cardRepository.save(card);

        bookRepository.updateBook(book);

        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);

        transactionRepository.save(transaction);
        //This saving of transcation can't be avoided bcz card is not bidirectionally connected to txn
        //and for the book we are not calling the inbuilt .save function



        return transaction.getTransactionId();
    }

    public Transaction returnBook(int cardId, int bookId) throws Exception{

        List<Transaction> transactions = transactionRepository.find(cardId,bookId,TransactionStatus.SUCCESSFUL,true);
        Transaction transaction = transactions.get(transactions.size() - 1);

        Date issueDate = transaction.getTransactionDate();

        long timeIssuetime = Math.abs(System.currentTimeMillis() - issueDate.getTime());

        long no_of_days_passed = TimeUnit.DAYS.convert(timeIssuetime, TimeUnit.MILLISECONDS);

        int fine = 0;
        if(no_of_days_passed > getMax_allowed_days){
            fine = (int)((no_of_days_passed - getMax_allowed_days) * fine_per_day);
        }

        Book book = transaction.getBook();

        book.setAvailable(true);
        book.setCard(null);

        bookRepository.updateBook(book);

        Transaction tr = new Transaction();
        tr.setBook(transaction.getBook());
        tr.setCard(transaction.getCard());
        tr.setIssueOperation(false);
        tr.setFineAmount(fine);
        tr.setTransactionStatus(TransactionStatus.SUCCESSFUL);

        transactionRepository.save(tr);

        return tr;
    }
}
