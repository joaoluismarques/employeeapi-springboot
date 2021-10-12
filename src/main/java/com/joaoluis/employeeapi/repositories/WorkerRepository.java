package com.joaoluis.employeeapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.employeeapi.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Optional<Worker> findByCpf(String cpf);

}
