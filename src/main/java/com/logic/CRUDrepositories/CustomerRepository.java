package com.logic.CRUDrepositories;

import com.logic.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    //Customer findAllByCard_numIn();
}
