package com.logic.CRUDrepositories;

import com.logic.models.Body;
import org.springframework.data.repository.CrudRepository;

public interface BodyRepository extends CrudRepository<Body,Integer> {
    Body findAllByBody(String body);
}
