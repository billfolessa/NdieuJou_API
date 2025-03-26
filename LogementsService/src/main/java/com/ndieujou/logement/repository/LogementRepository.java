package com.ndieujou.logement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndieujou.logement.entity.Logement;

public interface LogementRepository extends JpaRepository<Logement, Long> {

}
