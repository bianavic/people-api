package com.digitalinnovation.peopleapi.service;

import com.digitalinnovation.peopleapi.dto.mapper.PersonMapper;
import com.digitalinnovation.peopleapi.dto.request.PersonDTO;
import com.digitalinnovation.peopleapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.peopleapi.entity.Person;
import com.digitalinnovation.peopleapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.digitalinnovation.peopleapi.utils.PersonUtils.createFakeDTO;
import static com.digitalinnovation.peopleapi.utils.PersonUtils.createFakeEntity;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks // insere o repository dentro da classe de service
    private PersonService personService;

    @Test
    void testGivenPersonDTOThemReturnSavedMessage() {

        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO
                .builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }


}