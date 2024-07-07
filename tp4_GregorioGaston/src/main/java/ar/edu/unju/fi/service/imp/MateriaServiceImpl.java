package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceCollection")
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public List<MateriaDTO> findAll() {
		
		List<MateriaDTO> materiaDTO = materiaMapper.toMateriaDTOList(CollectionMateria.getMaterias());
		
		return materiaDTO;
	}

	@Override
	public MateriaDTO findByCod(int codigo) {
		
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(CollectionMateria.buscarMateria(codigo));
		
		return materiaDTO;
	}

	@Override
	public Materia save(MateriaDTO materiaDTO) {
		
		CollectionMateria.agregarMateria(materiaMapper.toMateria(materiaDTO));

		Materia materia = CollectionMateria.buscarMateria(materiaDTO.getCodigo());
		
		return materia;
	}

	@Override
	public void deleteByCod(int codigo) {
		
		CollectionMateria.eliminarMateria(codigo);

	}

	@Override
	public void edit(MateriaDTO materiaDTO) throws Exception {

		//CollectionMateria.modificarMateria(materiaMapper.toMateria(materiaDTO));

	}

	@Override
	public boolean existsByNombre(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
