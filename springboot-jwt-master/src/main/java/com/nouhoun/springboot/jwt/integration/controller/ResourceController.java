package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.dao.CandidatoDAO;
import com.nouhoun.springboot.jwt.integration.domain.Candidato;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.GenericService;

import java.util.List;

@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;
   
    @RequestMapping(value ="/mostrarCandidatos")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<CandidatoDAO> getCandidatos(
    		@RequestParam(value="dni", defaultValue="") String dni, 
    	    @RequestParam(value="nombreApellido", defaultValue="") String nombreApellido){
        return userService.findCandidatos(dni,nombreApellido);
    }
    
    @RequestMapping(value ="/mostrarCandidato")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Candidato getCandidato(@RequestParam(value="dni") Integer dni){
        return userService.findCandidato(dni);
    }
        
    @RequestMapping(value ="/altaCandidato")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public String altaCandidato(
    		@RequestParam(value="dni") Integer dni, 
    		@RequestParam(value="nombreApellido") String nombreApellido,
    		@RequestParam(value="fechaNacimiento") String fechaNacimiento,
    		@RequestParam(value="domicilio") String domicilio,
    		@RequestParam(value="telefono") String telefono,
    		@RequestParam(value="email") String email){
        return userService.altaCandidato(dni, nombreApellido, fechaNacimiento, domicilio, telefono, email);
    }
    
    @RequestMapping(value ="/modificarCandidato")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public String modificarCandidato(
    		@RequestParam(value="dni", defaultValue="") Integer dni, 
    		@RequestParam(value="nombreApellido", defaultValue="") String nombreApellido,
    		@RequestParam(value="fechaNacimiento", defaultValue="") String fechaNacimiento,
    		@RequestParam(value="domicilio", defaultValue="") String domicilio,
    		@RequestParam(value="telefono", defaultValue="") String telefono,
    		@RequestParam(value="email", defaultValue="") String email){
        return userService.modificarCandidato(dni, nombreApellido, fechaNacimiento, domicilio, telefono, email);
    }
        
    @RequestMapping(value ="/eliminarCandidato")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public String eliminarCandidato(@RequestParam(value="dni") Integer dni ){
        return userService.eliminarCandidato(dni);
    }
}
