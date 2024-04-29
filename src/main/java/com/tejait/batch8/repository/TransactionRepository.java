package com.tejait.batch8.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.TransactionHistory;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory, Integer> {

	boolean existsByAppid(Integer appid);

	List<TransactionHistory> findByAppid(Integer appid);

	List<TransactionHistory> findByTransactionStatusIn(List<String> statusOrInstrumentTypesList);

	List<TransactionHistory> findByInstrumentIn(List<String> statusOrInstrumentTypesList);

	List<TransactionHistory> findByTransactionDateGreaterThanEqual(Date newdate);

	List<TransactionHistory> findByTransactionDateBetween(Date startDate, Date endDate);

}
