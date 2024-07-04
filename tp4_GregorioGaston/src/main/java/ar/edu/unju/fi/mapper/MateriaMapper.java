package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapper {
	
	@Mapping(source = "docente", target = "docente")
	@Mapping(source = "carrera", target = "carrera")
	MateriaDTO toMateriaDTO(Materia materia);
	
	//@InheritConfiguration
	//Materia toMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> toMateriaDTOList(List<Materia> materias);
	
	List<Materia> toMateriaList(List<MateriaDTO> materiasDTO);

}
