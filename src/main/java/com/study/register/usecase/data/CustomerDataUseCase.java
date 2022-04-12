package com.study.register.usecase.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CustomerDataUseCase {

    private UUID id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String document;

    private String email;

    private String cellphone;

    private LocalDate birthdate;

    @ColumnDefault(value = "true")
    @JsonProperty("is_active")
    private Boolean isActive = Boolean.TRUE;
}
