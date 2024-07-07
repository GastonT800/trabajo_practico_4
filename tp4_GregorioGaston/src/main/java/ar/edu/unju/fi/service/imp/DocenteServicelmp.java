package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;


@Service("docenteServiceMysql")
public class DocenteServicelmp implements IDocenteService {
	
	private static Logger logger = LoggerFactory.getLogger(AlumnoServiceImp.class);
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private DocenteMapper docenteMapper;
	
	//GET ALL //READ
	@Override
	public List<DocenteDTO> findAll() {
		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docenteRepository.findAll());
		if(docentesDTO.isEmpty())
			logger.warn("No se pudo cargar la lista de Docentes");
		else 
			logger.info("Se listo correctamente la lista de Docentes");
		return docentesDTO;
	}

	//FIND
	@Override
	public DocenteDTO findById(int id) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());
		if(docenteDTO != null)
			logger.info("Se encontro el objeto alumno con legajo " + id);
		else 
			logger.error("No se encontro el objeto alumno con legajo " + id);
		return docenteDTO;
	}

	//ADD //SAVE
	@Override
	public Docente save(DocenteDTO docenteDTO) {
		Docente docente = docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		if(docente != null)
	    	logger.info("El objeto Docente se guardo con exito");
	    else 
	    	logger.error("EL objeto Docente no se puede guardar con exito");
		return docente;
	}

	//DELETE
	@Override
	public void deleteById(int id) {
		Optional<Docente> optionalDocente = docenteRepository.findById(id);
	    if (optionalDocente.isPresent()) {
	        Docente docente = optionalDocente.get();
	        docente.setEstado(false);
	        docenteRepository.save(docente);
	        logger.warn("El objeto Docente con legajo " + id + " se eliminó con éxito!");
	    } else {
	        logger.error("No se encontró el objeto Docente con legajo " + id);
	    }
	}

	//UPDATE
	@Override
	public void edit(DocenteDTO docenteDTO) throws Exception {
		docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		logger.info("Se edito con exito el obejto Docente con legajo " + docenteDTO.getLegajo());
	}

}
