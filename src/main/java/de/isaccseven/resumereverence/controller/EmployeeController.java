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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDAO> findEmployeeById(@PathVariable String id){
        return employeeRepository.findById(Long.valueOf(id));
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAllEmployee(){
        return employeeRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteEmployeeById(@PathVariable String id) {
        return employeeRepository.deleteById(Long.valueOf(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDAO> generateEmployeeEntry(@RequestBody(required = false) EmployeeDAO employeeDAO){
        return employeeRepository.save(Objects.requireNonNullElseGet(employeeDAO, EmployeeDAO::new));
    }
}
