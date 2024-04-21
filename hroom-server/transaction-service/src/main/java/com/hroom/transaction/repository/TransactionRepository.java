package com.hroom.transaction.repository;

import com.hroom.Transaction.entity.Transaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
