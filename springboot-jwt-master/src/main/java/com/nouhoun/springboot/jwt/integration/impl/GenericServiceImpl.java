package com.nouhoun.springboot.jwt.integration.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.dao.CandidatoDAO;
import com.nouhoun.springboot.jwt.integration.domain.Candidato;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.repository.CandidatoRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.GenericService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    
    
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /************************************************************/
	@Override
	public List<CandidatoDAO> findCandidatos(String dni,String nombreApellido) {
		List<Candidato> candidatos=(List<Candidato>) candidatoRepository.findAll();
		List<CandidatoDAO> candidatosFiltrados=  new ArrayList<>();
		for(Candidato c : candidatos) {
			if((!dni.equals("") && c.getDni().toString().contains(dni)) || (!nombreApellido.equals("")) && c.getNombreApellido().toLowerCase().contains(nombreApellido.toLowerCase())) {
				CandidatoDAO cd= new CandidatoDAO(c.getDni(),c.getNombreApellido());
				candidatosFiltrados.add(cd);
			}
		}
		return candidatosFiltrados;
	}

	
	@Override
	public Candidato findCandidato(Integer dni) {
		try {
			Candidato c=candidatoRepository.findById(dni).get();
			return c;
		}catch(Exception e) {
			return null;
		}
	}
	
	public String altaCandidato(Integer dni,String nombreApellido,String fechaNacimiento,String domicilio,String telefono,String email) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date date = formatter.parse(fechaNacimiento);
			Candidato c= new Candidato(dni, nombreApellido, date, domicilio, telefono, email);
			candidatoRepository.save(c);
			return "Candidato guardado correctamente";
		} catch (ParseException e) {
            //System.out.println("ParseError " + e.getMessage());
            return "Error en el formato de la fecha";
		}catch(Exception e) {
			return "No se pudo guardar el candidato";
		}
	}

	
	@Override
	public String modificarCandidato(Integer dni,String nombreApellido,String fechaNacimiento,String domicilio,String telefono,String email) {
		if(dni != null )  {
			try {
				Candidato c=candidatoRepository.findById(dni).get();
				if(nombreApellido!= null && !nombreApellido.equals("") ) 
					c.setNombreApellido(nombreApellido);
				if(fechaNacimiento!= null && !fechaNacimiento.equals("") ) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			        Date date = formatter.parse(fechaNacimiento);
					c.setFechaNacimiento(date);
				}
				if(domicilio!= null && !domicilio.equals("") ) 
					c.setDomicilio(domicilio);
				if(telefono!= null && !telefono.equals("") ) 
					c.setTelefono(telefono);
				if(email!= null && !email.equals("") ) 
					c.setEmail(email);
				candidatoRepository.save(c);
				return "Candidato modificado correctamente";
			} catch (ParseException e) {
	            //System.out.println("ParseError " + e.getMessage());
	            return "Error en el formato de la fecha";
			}catch(Exception e) {
				return "No se encontró el candidato a modificar";
			}
		}else
			return "Error al realizar la modificación";
	}
	
	@Override
	public String eliminarCandidato(Integer dni) {
		try {
			Candidato c=candidatoRepository.findById(dni).get();
			candidatoRepository.delete(c);
			return "Candidato eliminado correctamente";
		}catch(Exception e) {
			return "No se encontró el candidato a eliminar";
		}			
	}

}
