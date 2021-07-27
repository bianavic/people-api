package com.digitalinnovation.peopleapi.repository;

import com.digitalinnovation.peopleapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
