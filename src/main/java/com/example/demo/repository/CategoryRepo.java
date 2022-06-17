package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
