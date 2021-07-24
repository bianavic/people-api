package com.digitalinnovation.peopleapi.dto.mapper;

import com.digitalinnovation.peopleapi.dto.request.PersonDTO;
import com.digitalinnovation.peopleapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  // cria-se uma constante INSTANCE que retorno PersonMapper

  // @Mapping formatacao de datas para entidades, de strings para um tipo de data q consiga ser inserido no banco de dados
  // "toModel" é uma convencao para converter DTO para banco de dados
  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
  Person toModel(PersonDTO personDTO);

  PersonDTO toDTO(Person person);

}
