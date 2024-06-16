package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.service.IAlumnoService;


@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private AlumnoMapper alumnoMapper;

	@Override
	public List<AlumnoDTO> findAll() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(CollectionAlumno.getAlumnos());
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findById(int id) {
		 AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(CollectionAlumno.buscarAlumno(id));
		return alumnoDTO;
	}

	@Override
	public boolean save(AlumnoDTO alumnoDTO) {
		boolean respuesta = CollectionAlumno.agregarAlumno(alumnoMapper.toAlumno(alumnoDTO));
		return respuesta;
	}

	@Override
	public void deleteById(int id) {
		CollectionAlumno.eliminarAlumno(id);

	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) throws Exception {
		CollectionAlumno.modificarAlumno(alumnoMapper.toAlumno(alumnoDTO));

	}

}
