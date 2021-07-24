package com.digitalinnovation.peopleapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

  HOME("home"),
  MOBILE("mobile"),
  COMERCIAL("comercial");

  private final String description;

}
