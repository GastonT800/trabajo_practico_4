package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service("carreraServiceMysql")
public class CarreraServiceImp implements ICarreraService {
	
	private static Logger logger = LoggerFactory.getLogger(CarreraServiceImp.class);
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private CarreraMapper carreraMapper;
	
	@Autowired
	private AlumnoMapper alumnoMapper;

	@Override
	public List<CarreraDTO> findAll() {

		List<CarreraDTO> carreraDTO = carreraMapper.toCarreraDTOList(carreraRepository.findByActivo(true));
		
		if(carreraDTO.isEmpty()) {
			logger.warn("La lista de carreras se encuentra vacia");
		}else {
			logger.info("La lista de carreras fue cargada con exito!");
		}
		
		return carreraDTO;
	}

	@Override
	public CarreraDTO findByCod(int codigo) {
		
		return carreraMapper.toCarreraDTO(carreraRepository.findById(codigo).get());
	}

	@Override
	public Carrera save(CarreraDTO carreraDTO) {

		Carrera carrera = carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
		
		if(carrera !=null) {
			logger.info("El objeto carrera se guardó con exito");
		}else {
			logger.error("El objeto carrera no se pudo guardar");
		}
		
		return carrera;
	}

	@Override
	public void deleteByCod(int codigo) {

		Carrera carrera = carreraRepository.findById(codigo).get();
		carrera.setActivo(false);
		carreraRepository.save(carrera);
		logger.warn("Objeto carrera eliminado!");
		
	}

	@Override
	public void edit(CarreraDTO carreraDTO) throws Exception {

		carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
		logger.info("Objeto carrera modificado!");
		
	}

	@Override
	public List<AlumnoDTO> findAlumnosByCarrera(int codigo) {
		Optional<Carrera> carrera = carreraRepository.findByIdWithAlumnos(codigo);
		if(carrera.isPresent()) {
			List<Alumno> alumnos = carrera.get().getAlumnos();
			return alumnoMapper.toAlumnoDTOList(alumnos);
		}else 
			return List.of();
	}
}
