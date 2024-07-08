package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{

	List<Carrera> findByActivo(boolean activo);
	
	@Query("SELECT c FROM Carrera c LEFT JOIN FETCH c.alumnos a WHERE c.codigo = :id")
	Optional<Carrera> findByIdWithAlumnos(@Param("id") int id);
	
}
