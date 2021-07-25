package com.digitalinnovation.peopleapi.service;

import com.digitalinnovation.peopleapi.dto.mapper.PersonMapper;
import com.digitalinnovation.peopleapi.dto.request.PersonDTO;
import com.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.peopleapi.entity.Person;
import com.digitalinnovation.peopleapi.exception.PersonNotFoundException;
import com.digitalinnovation.peopleapi.repository.PersonRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  private final PersonMapper personMapper;

  @Autowired
  public PersonService(PersonRepository personRepository,
      PersonMapper personMapper) {
    this.personRepository = personRepository;
    this.personMapper = personMapper;
  }

  public MessageResponseDTO create(PersonDTO personDTO) {
    // conversao de person DTO para entidades pq repository salva apenas entidades
    Person person = personMapper.toModel(personDTO);
    Person savedPerson = personRepository.save(person);

    MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());    // utilizando o builder evita criar direto no construtor,
    // passando e tratando de forma mais encapsulada os dados de entrada
    return messageResponse;

  }

  public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    // converter allPeople em uma lista de objetos do tipo DTO
    return allPeople.stream()
        .map(personMapper::toDTO) // de etnidade para DTO
        .collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    return personMapper.toDTO(person);
  }

  public void delete(Long id) throws PersonNotFoundException {
    verifyIfExists(id);
    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateById(Long id, PersonDTO personDTO)
      throws PersonNotFoundException {

    verifyIfExists(id);

    Person personToSUpdate = personMapper.toModel(personDTO);
    Person updatedPerson = personRepository.save(personToSUpdate);

    MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", updatedPerson.getId());    // utilizando o builder evita criar direto no construtor,
    return messageResponse;

  }

  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
  }

  private MessageResponseDTO createMessageResponse(String message, Long id) {
    return MessageResponseDTO
        .builder()
        .message(message + id)
        .build();
  }

}
