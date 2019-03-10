package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.dao.CandidatoDAO;
import com.nouhoun.springboot.jwt.integration.domain.Candidato;
import com.nouhoun.springboot.jwt.integration.domain.User;


public interface GenericService {
    User findByUsername(String username);

	List<CandidatoDAO> findCandidatos(String dni,String nombreApellido);

	Candidato findCandidato(Integer dni);

	String altaCandidato(Integer dni,String nombreApellido,String fechaNacimiento,String domicilio,String telefono,String email);
	
	String modificarCandidato(Integer dni,String nombreApellido,String fechaNacimiento,String domicilio,String telefono,String email);
	
	String eliminarCandidato(Integer dni);
	
}
