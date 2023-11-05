package com.sprintform.hw.application.repository.transaction;

import com.sprintform.hw.application.model.entity.transaction.Transaction;
import com.sprintform.hw.application.repository.base.FilterableJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for transaction operations.
 *
 * @author zellerpeter
 */
@Repository
public interface TransactionRepository extends FilterableJpaRepository<Transaction> {

}
