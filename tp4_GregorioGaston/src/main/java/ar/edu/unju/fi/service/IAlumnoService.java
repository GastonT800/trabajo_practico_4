package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
  
	List<AlumnoDTO> findAll();
	
	//FIJARME SI ES ID o DEBERIA SER OTRO EL NOMBRE DEL CAMPO ENVIADO POR PARAMETRO
	
	AlumnoDTO findById(int id);
	
	boolean save(AlumnoDTO alumnoDTO);
	
	void deleteById(int id);
	
	void edit(AlumnoDTO alumnoDTO) throws Exception;
}
