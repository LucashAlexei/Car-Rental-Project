package com.logic.CRUDrepositories;

import com.logic.models.Body;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BodyRepository extends JpaRepository<Body,Integer> {
    Body findAllByBody(String body);
}
