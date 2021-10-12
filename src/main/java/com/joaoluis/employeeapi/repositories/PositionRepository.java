package com.joaoluis.employeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.employeeapi.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
