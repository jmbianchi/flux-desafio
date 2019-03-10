package com.nouhoun.springboot.jwt.integration.repository;


import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.Candidato;

public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {

}
