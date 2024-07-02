package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

public interface IAlumnoService {
  
	List<AlumnoDTO> findAll();
	
	
	AlumnoDTO findByLu(int lu);
	
	Alumno save(AlumnoDTO alumnoDTO);
	
	void deleteByLu(int lu);
	
	void edit(AlumnoDTO alumnoDTO) throws Exception;
}
