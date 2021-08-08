package com.od.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.od.enums.OrderStatusType;
import com.od.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.trxRefId= ?1")
    Transaction findOrderByTransactionId (Long trxRefId);

    @Query("SELECT t FROM Transaction t WHERE CAST(t.created AS date) between ?1 and ?2 AND t.status = ?3")
    List<Transaction> getOrders(
            Date startDate,
            Date endDate,
            OrderStatusType status,
            Pageable pageable);

}
