package com.digitalinnovation.peopleapi.dto.request;

import com.digitalinnovation.peopleapi.entity.Phone;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

  // dados de entrada que ao inves de serem mapeados
  // nas entidades serao mapeados aquino DTO
  // validacao em tempo de requisicao http, na propria camada de controller

  private Long id;
  @NotEmpty
  @Size(min = 2, max = 100)
  private String firstName;
  @NotEmpty
  @Size(min = 2, max = 100)
  private String lastName;
  @NotEmpty
  // TODO add annotation @CPF
  private String cpf;
  @NotNull
  private String birthDate;
  @Valid // valida cada 1 dos dados da lista
  @NotEmpty
  private List<Phone> phones;

}