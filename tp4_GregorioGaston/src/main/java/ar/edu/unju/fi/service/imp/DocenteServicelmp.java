package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;


@Service("docenteServiceMysql")
public class DocenteServicelmp implements IDocenteService {
	
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private DocenteMapper docenteMapper;
	
	//GET ALL //READ
	@Override
	public List<DocenteDTO> findAll() {
		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docenteRepository.findAll());
		return docentesDTO;
	}

	//FIND
	@Override
	public DocenteDTO findById(int id) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());
		return docenteDTO;
	}

	//ADD //SAVE
	@Override
	public Docente save(DocenteDTO docenteDTO) {
		Docente docente = docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		return docente;
	}

	//DELETE
	@Override
	public void deleteById(int id) {
		Docente docente = docenteRepository.findById(id).get();
		docente.setEstado(false);
		docenteRepository.save(docente);
	}

	//UPDATE
	@Override
	public void edit(DocenteDTO docenteDTO) throws Exception {
		docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		
	}

}
