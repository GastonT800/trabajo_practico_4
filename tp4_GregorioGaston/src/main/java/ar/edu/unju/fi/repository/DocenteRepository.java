package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
	
	List<Docente> findAll();
	
	@Query("SELECT d FROM Docente d WHERE d.legajo NOT IN (SELECT m.docente.legajo FROM Materia m)") 
    List<Docente> findDocentesWithoutMateria();

}
