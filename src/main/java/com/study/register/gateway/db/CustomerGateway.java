package com.study.register.gateway.db;

import com.study.register.gateway.db.entity.CustomerEntity;
import com.study.register.gateway.db.repository.CustomerRepository;
import com.study.register.usecase.data.CustomerDataUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CustomerGateway {

    private final CustomerRepository repository;

    private final ModelMapper modelMapper;

    public CustomerDataUseCase create(CustomerDataUseCase useCase) {
        CustomerEntity entity = modelMapper.map(useCase, CustomerEntity.class);
        entity.setCreatedAt(LocalDate.now());
        return modelMapper.map(repository.save(entity), CustomerDataUseCase.class);
    }

}
