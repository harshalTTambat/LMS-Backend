package com.LMSbackend.LMS_backendApplication.Repository;

import com.LMSbackend.LMS_backendApplication.Enums.TransactionStatus;
import com.LMSbackend.LMS_backendApplication.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    // sort on the basis of time to get the latest issue date
    @Query("select t from Transaction t where t.card.id=:cardId and t.book.id=:bookId and t.isIssueOperation=:isIssue and t.transactionStatus=:status")
    public List<Transaction> find(int cardId, int bookId, TransactionStatus status, boolean isIssue);
}
