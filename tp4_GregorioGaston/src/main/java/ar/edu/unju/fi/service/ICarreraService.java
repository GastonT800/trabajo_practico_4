package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	
	//Obtener Lista de Carreras
	List<CarreraDTO> findAll();
	
	//Metodos
	CarreraDTO findByCod(int codigo);
	
	boolean save(CarreraDTO carreraDTO);
	
	void deleteByCod(int codigo);
	
	void edit(CarreraDTO carreraDTO) throws Exception;
	
}
