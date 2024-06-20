package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
  
	List<AlumnoDTO> findAll();
	
	
	AlumnoDTO findByLu(int lu);
	
	boolean save(AlumnoDTO alumnoDTO);
	
	void deleteByLu(int lu);
	
	void edit(AlumnoDTO alumnoDTO) throws Exception;
}
