package com.digitalinnovation.peopleapi.utils;

import com.digitalinnovation.peopleapi.dto.request.PhoneDTO;
import com.digitalinnovation.peopleapi.entity.Phone;
import com.digitalinnovation.peopleapi.entity.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "11111111111";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
