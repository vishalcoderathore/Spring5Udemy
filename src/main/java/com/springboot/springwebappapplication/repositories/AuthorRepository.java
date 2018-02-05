package com.springboot.springwebappapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.springwebappapplication.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
