package de.isaccseven.resumereverence.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeDAO, Long>{}
