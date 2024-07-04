package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

public interface IDocenteService {
	
	
	List<DocenteDTO> findAll();
	
	DocenteDTO findById(int id);
	
	Docente save(DocenteDTO docenteDTO);
	
	void deleteById(int id);

	void edit(DocenteDTO docenteDTO) throws Exception;
}
