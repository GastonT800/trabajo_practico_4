package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.service.ICarreraService;

@Service("carreraServiceCollection")
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	private CarreraMapper carreraMapper;
	
	@Override
	public List<CarreraDTO> findAll() {

		List<CarreraDTO> carreraDTO = carreraMapper.toCarreraDTOList(CollectionCarrera.getCarreras());
		
		return carreraDTO;
	}

	@Override
	public CarreraDTO findByCod(int codigo) {

		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(CollectionCarrera.buscarCarrera(codigo));
		
		return carreraDTO;
	}

	@Override
	public Carrera save(CarreraDTO carreraDTO) {
		
		CollectionCarrera.agregarCarrera(carreraMapper.toCarrera(carreraDTO));

		Carrera carrera = CollectionCarrera.buscarCarrera(carreraDTO.getCodigo());
		
		return carrera;
	}

	@Override
	public void deleteByCod(int codigo) {

		CollectionCarrera.eliminarCarrera(codigo);

	}

	@Override
	public void edit(CarreraDTO carreraDTO) throws Exception  {

		CollectionCarrera.modificarCarrera(carreraMapper.toCarrera(carreraDTO));

	}

}
