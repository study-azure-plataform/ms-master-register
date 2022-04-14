package com.study.register.gateway.db.entity;


import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;

    @CreatedDate
    @Column(name = "created_at")
    protected LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDate updatedAt;

}