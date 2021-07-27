package com.digitalinnovation.peopleapi.dto.request;

import com.digitalinnovation.peopleapi.entity.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

  // dados de entrada

  private Long id;
  @Enumerated(EnumType.STRING)
  private PhoneType type;
  @NotEmpty
  @Size(min = 13, max = 14)
  private String number;

}
