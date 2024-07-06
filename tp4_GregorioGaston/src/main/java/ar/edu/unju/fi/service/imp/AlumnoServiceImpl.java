package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;

@Service("alumnoServiceCollection")
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private AlumnoMapper alumnoMapper;

	@Override
	public List<AlumnoDTO> findAll() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(CollectionAlumno.getAlumnos());
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findByLu(int lu) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(CollectionAlumno.buscarAlumno(lu));
		return alumnoDTO;
	}

	@Override
	public Alumno save(AlumnoDTO alumnoDTO) {
		CollectionAlumno.agregarAlumno(alumnoMapper.toAlumno(alumnoDTO));
		Alumno alumno = CollectionAlumno.buscarAlumno(alumnoDTO.getLu());
		return alumno;
	}

	@Override
	public void deleteByLu(int lu) {
		CollectionAlumno.eliminarAlumno(lu);
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) throws Exception {
		CollectionAlumno.modificarAlumno(alumnoMapper.toAlumno(alumnoDTO));

	}
}
