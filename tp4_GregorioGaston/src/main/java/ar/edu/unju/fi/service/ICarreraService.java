package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

public interface ICarreraService {
	
	//Obtener Lista de Carreras
	List<CarreraDTO> findAll();
	
	//Metodos
	CarreraDTO findByCod(int codigo);
	
	Carrera save(CarreraDTO carreraDTO);
	
	void deleteByCod(int codigo);
	
	void edit(CarreraDTO carreraDTO) throws Exception;
	
	public List<AlumnoDTO> findAlumnosByCarrera(int codigo);
}
