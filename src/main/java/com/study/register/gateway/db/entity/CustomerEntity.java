package com.study.register.gateway.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity extends AbstractEntity{

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private String phone;

    private LocalDate birthdate;

    private Boolean isActive = Boolean.TRUE;

}
