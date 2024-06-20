package ar.edu.unju.fi.service.imp;
/*
import java.util.List;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.IMateriaService;

public class MateriaServiceImpl implements IMateriaService {

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
	public boolean save(MateriaDTO materiaDTO) {
		
		boolean respuesta = CollectionMateria.getMaterias(materiaMapper.toMateria(materiaDTO));
		
		return respuesta;
	}

	@Override
	public void deleteByCod(int codigo) {
		
		CollectionMateria.eliminarMateria(codigo);

	}

	@Override
	public void edit(MateriaDTO materiaDTO) throws Exception {

		CollectionMateria.modificarMateria(materiaMapper.toMateria(materiaDTO));

	}

}
*/