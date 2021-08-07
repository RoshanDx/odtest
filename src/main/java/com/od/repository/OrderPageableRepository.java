package com.od.repository;

import com.od.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderPageableRepository extends PagingAndSortingRepository<Transaction,Long> {
}
