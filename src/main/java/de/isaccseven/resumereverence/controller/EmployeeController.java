package de.isaccseven.resumereverence.controller;


import de.isaccseven.resumereverence.persistence.EmployeeDAO;
import de.isaccseven.resumereverence.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<EmployeeDAO> findAllEmployee(){
        return employeeRepository.findAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAllEmployee(){
        return employeeRepository.deleteAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDAO> generateEmployeeEntry(@RequestBody(required = false) EmployeeDAO employeeDAO){
        return employeeRepository.save(Objects.requireNonNullElseGet(employeeDAO, EmployeeDAO::new));
    }
}
