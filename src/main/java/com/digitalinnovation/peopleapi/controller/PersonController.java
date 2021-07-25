package com.digitalinnovation.peopleapi.controller;

import com.digitalinnovation.peopleapi.dto.request.PersonDTO;
import com.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.peopleapi.exception.PersonNotFoundException;
import com.digitalinnovation.peopleapi.service.PersonService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

  private PersonService personService;

  // @RequestBody informa q esta vindo uma requisicao do tipo pessoa
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
    return personService.create(personDTO);
  }

  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @GetMapping("/{id}")
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @PutMapping("/{id}")
  public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
      throws PersonNotFoundException {
    return personService.updateById(id, personDTO);

  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.delete(id);
  }

}
