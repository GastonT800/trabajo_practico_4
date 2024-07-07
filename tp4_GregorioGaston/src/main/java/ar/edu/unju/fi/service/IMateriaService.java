package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

public interface IMateriaService {
	
	//Obtener lista de Materias
	List<MateriaDTO> findAll();
	
	//Metodos
	MateriaDTO findByCod(int codigo);
	
	Materia save(MateriaDTO materiaDTO);
	
	void deleteByCod(int codigo);
	
	void edit(MateriaDTO materiaDTO) throws Exception;
	
	boolean existsByNombre(String nombre);

}
