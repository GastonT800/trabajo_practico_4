package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceMysql")
public class MateriaServiceImp implements IMateriaService {
	
	private static Logger logger = LoggerFactory.getLogger(MateriaServiceImp.class);
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public List<MateriaDTO> findAll() {
		
		List<MateriaDTO> materiaDTO = materiaMapper.toMateriaDTOList(materiaRepository.findByEstado(true));
		
		if(materiaDTO.isEmpty())
			logger.error("La lista de materias se encuentra vacia");
		else
			logger.info("La lista de materias fue cargada con exito!");
		
		return materiaDTO;
		
	}

	@Override
	public MateriaDTO findByCod(int codigo) {
		
		return materiaMapper.toMateriaDTO(materiaRepository.findById(codigo).get());
		
	}

	@Override
	public Materia save(MateriaDTO materiaDTO) {
		
		Materia materia = materiaRepository.save(materiaMapper.toMateria(materiaDTO));

		if(materia !=null) {
			logger.info("El objeto materia se guardó con exito");
		}else {
			logger.error("El objeto materia no se pudo guardar");
		}
		
		return materia;
	}

	@Override
	public void deleteByCod(int codigo) {

		Materia materia = materiaRepository.findById(codigo).get();
		materia.setEstado(false);
		materiaRepository.save(materia);
		logger.warn("Objeto materia eliminado!");
	}

	@Override
	public void edit(MateriaDTO materiaDTO) throws Exception {

		materiaRepository.save(materiaMapper.toMateria(materiaDTO));
		logger.info("Objeto materia fue modificado con exito!");
		
	}

	/**
	 * Verifica si existe una materia con ese nombre
	 */
	@Override
	public boolean existsByNombre(String nombre) {   
		return materiaRepository.existsByNombre(nombre);
	}

}
