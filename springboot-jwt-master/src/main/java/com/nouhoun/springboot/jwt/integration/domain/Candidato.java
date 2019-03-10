package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "candidatos")
public class Candidato {
    @Id
    @Column(name = "dni")
    private Integer dni;
    
	@Column(name = "nombreApellido")
    private String nombreApellido;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;  
        
    @Column(name = "domicilio")
    private String domicilio;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email;
    
    
    public Candidato(){

    }

    public Candidato(Integer dni,String nombreApellido,Date fechaNacimiento,String domicilio,String telefono,String email) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
