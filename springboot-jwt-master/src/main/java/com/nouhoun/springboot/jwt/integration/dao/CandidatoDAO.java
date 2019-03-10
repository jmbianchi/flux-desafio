package com.nouhoun.springboot.jwt.integration.dao;

public class CandidatoDAO {
    private Integer dni;
    private String nombreApellido;

    public CandidatoDAO(){

    }

    public CandidatoDAO(Integer dni,String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
    } 
    
    public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	
}