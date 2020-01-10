package com.technical.interview.technicalinterview.repository;

import com.technical.interview.technicalinterview.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}