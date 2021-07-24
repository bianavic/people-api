package com.digitalinnovation.peopleapi.controller;

import com.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.peopleapi.entity.Person;
import com.digitalinnovation.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonRepository personRepository;

  // a injecao pelo construtor facilita para testes unitarios (criando mocks)
  @Autowired
  public PersonController(
      PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  // @RequestBody informa q esta vindo uma requisicao do tipo pessoa
  @PostMapping
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    Person savedPerson = personRepository.save(person);
    // utilizando o builder evita criar direto no construtor,
    // passando e tratando de forma mais encapsulada os dados de entrada
    return MessageResponseDTO
        .builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
  }

}
