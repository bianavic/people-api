package com.digitalinnovation.peopleapi.service;

import com.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.peopleapi.entity.Person;
import com.digitalinnovation.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public MessageResponseDTO createPerson(Person person) {
    Person savedPerson = personRepository.save(person);
    // utilizando o builder evita criar direto no construtor,
    // passando e tratando de forma mais encapsulada os dados de entrada
    return MessageResponseDTO
        .builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
  }

}
