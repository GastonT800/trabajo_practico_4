package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;

@Service("docenteServicelmpl")
public class DocenteServicelmpl implements IDocenteService {
	
	@Autowired
	private DocenteMapper docenteMapper;

	
	//GET ALL //READ
	@Override
	public List<DocenteDTO> findAll() {
		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(CollectionDocente.getDocentes());
		return docentesDTO;
	}

	//FIND
	@Override
	public DocenteDTO findById(int id) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(CollectionDocente.buscarDocente(id));
		return docenteDTO;
	}

	//ADD //SAVE
	@Override
	public Docente save(DocenteDTO docenteDTO) {
		//Docente respuesta = CollectionDocente.agregarDocente(docenteMapper.toDocente(docenteDTO));
		Docente respuesta = new Docente();
		return respuesta;
	}

	//DELETE
	@Override
	public void deleteById(int id) {
		CollectionDocente.eliminarDocente((short)id);
		
	}

	//UPDATE
	@Override
	public void edit(DocenteDTO docenteDTO) throws Exception {
		CollectionDocente.modificarDocente(docenteMapper.toDocente(docenteDTO));
		
	}

	@Override
	public List<DocenteDTO> findDocentesWithoutMateria() {
		// TODO Auto-generated method stub
		return null;
	}

}
