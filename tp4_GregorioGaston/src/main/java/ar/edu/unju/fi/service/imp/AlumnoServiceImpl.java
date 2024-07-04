package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;


@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	private static Logger logger = LoggerFactory.getLogger(AlumnoServiceImpl.class);
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoMapper alumnoMapper;

	@Override
	public List<AlumnoDTO> findAll() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnoRepository.findByEstado(true));
		if(alumnosDTO.isEmpty())
			logger.warn("No se pudo cargar la lista de alumnos");
		else 
			logger.info("Se listo correctamente la lista de alumnos");
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findByLu(int lu) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(alumnoRepository.findById(lu).get());
		if(alumnoDTO != null)
			logger.info("Se encontro el objeto alumno con libreta " + lu);
		else 
			logger.error("No se encontro el objeto alumno con libreta " + lu);
		return alumnoDTO;
	}

	@Override
	public Alumno save(AlumnoDTO alumnoDTO) {
	    Alumno alumno = alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
	    if(alumno != null)
	    	logger.info("El objeto Alumno se guardo con exito");
	    else 
	    	logger.error("EL objeto Alumno no se puede guardar con exito");
		return alumno;
	}

	@Override
	public void deleteByLu(int lu) {
	    Optional<Alumno> optionalAlumno = alumnoRepository.findById(lu);
	    if (optionalAlumno.isPresent()) {
	        Alumno alumno = optionalAlumno.get();
	        alumno.setEstado(false);
	        alumnoRepository.save(alumno);
	        logger.warn("El objeto Alumno con libreta " + lu + " se eliminó con éxito!");
	    } else {
	        logger.error("No se encontró el objeto Alumno con libreta " + lu);
	    }
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) throws Exception {
		alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
		logger.info("Se edito con exito el obejto Alumno con libreta " + alumnoDTO.getLu());
	}

}
