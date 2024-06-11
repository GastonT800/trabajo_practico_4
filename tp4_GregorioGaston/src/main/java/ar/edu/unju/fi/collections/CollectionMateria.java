package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Materia.Modalidad;

@Component
public class CollectionMateria {
	
	private static List<Materia> materias = new ArrayList<Materia>();
	
	
	/**
	 * devuelve un arrayList de objetos de la clase Materia 
	 * @return
	 */
	public static List<Materia> getMaterias(){
		
		if(materias.isEmpty()) {
			
			Docente docente = CollectionDocente.buscarDocente((short)2);
			Carrera carrera = CollectionCarrera.buscarCarrera((int)2);
			materias.add(new Materia(001, "Profesorado en Letras", "TERCERO", (short)36, Modalidad.VIRTUAL, docente, carrera ));
			
			Docente docente2 = CollectionDocente.buscarDocente((short)1);
			Carrera carrera2 = CollectionCarrera.buscarCarrera((int)1);
			materias.add(new Materia(002, "Licenciatura en Historia", "PRIMERO", (short)40, Modalidad.MIXTA, docente2, carrera2 ));
			
			return materias;
			
		}else {
			return materias;
		}
		
	}
	
	/**
	 * agrega un objeto materia al arrayList de materias
	 * @param materia
	 */
	public static void agregarMateria(Materia materia) {
		
		materias.add(materia);
	}
	
	/**
	 * elimina un objeto materia del arrayList de materias
	 * @param codigoMateria
	 */
	public static void eliminarMateria(int codigoMateria) {
		
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			
			if(iterator.next().getCodigo()== codigoMateria) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * modifica un objeto con los nuevos valores en 
	 * @param materia objeto con los valores de atributos modificados
	 */
	public static void modificarMateria(Materia materia) {
		
		for (Materia materi : materias) {
			
			if(materi.getCodigo() == materia.getCodigo()) {
				
				materi.setNombre(materia.getNombre());
				materi.setCurso(materia.getCurso());
				materi.setCantidadHoras(materia.getCantidadHoras());
				materi.setModalidad(materia.getModalidad());
				materi.setDocente(materia.getDocente());
				materi.setCarrera(materia.getCarrera());
				
			}else {
				System.out.println("El CODIGO no es valido");
			}
		}
	}
	
	/**
	 * busca un objeto materia dentro del ArrayList, el criterio es por
	 * @param codigo a buscar en el ArrayList materias
	 * @return
	 */
	public static Materia buscarMateria(int codigo) {
		
		Predicate<Materia> filterCodigo = cod -> cod.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		
		if(materia.isPresent()) {
			return materia.get();
			
		}else {
			return null;
		}
	}

}
