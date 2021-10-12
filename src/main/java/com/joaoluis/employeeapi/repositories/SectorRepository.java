package com.joaoluis.employeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.employeeapi.entities.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {

}
