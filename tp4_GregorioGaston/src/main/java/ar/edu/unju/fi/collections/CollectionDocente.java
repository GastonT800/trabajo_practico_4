package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	
	private static List<Docente> docentes = new ArrayList<Docente>();
	
	/**
	 * devuelve un arrayList de objetos de la clase Alumno
	 * @return
	 */
	public static List<Docente> getDocentes(){
		
		if(docentes.isEmpty()) {
			
			docentes.add(new Docente(10001, "Lucas", "Gómez", "juanG@gmail.com","3885723459L", true));
	        docentes.add(new Docente(10002, "María", "Pérez", "mariaP@gmail.com", "3884633902L", false));
	        docentes.add(new Docente( 10003, "Jorge", "Luna", "jorgeL@gmail.com", "388425678", false));
	        docentes.add(new Docente(10004, "Valeria", "Corro", "valeriaC@gmail.com", "3884767952", true));
	        
			return docentes;
			
		}else {
			return docentes;
		}
		
	}
	
	/**
	 * agrega un objeto docente al arrayList de docentes
	 * @param docente
	 */
	public static boolean  agregarDocente(Docente docente){
		
		return docentes.add(docente) ? true : false;
		
	}
	
	/**
	 * elimina un objeto docente del arrayList de docentes
	 * @param legajoDocente
	 */
	public static void eliminarDocente(int legajoDocente) {
		
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			
			if(iterator.next().getLegajo()== legajoDocente) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * modifica un objeto docente con los nuevos valores en 
	 * @param docente objeto con los valores de atributos modificados
	 */
	public static void modificarDocente(Docente docente)throws Exception {
		
		boolean encontrado = false;
		
		try {
			
			for(Docente docent : docentes) {
				
				if(docent.getLegajo() == docente.getLegajo()) {
					
					docent.setNombre(docente.getNombre());
					docent.setApellido(docente.getApellido());
					docent.setEmail(docente.getEmail());
					docent.setTelefono(docente.getTelefono());
					encontrado = true;
					
				}
			}
			if(!encontrado) {
				throw new Exception ("El docente con legajo " + docente.getLegajo() + " no existe");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		
	}
	
	/**
	 * busca un objeto docente dentro del ArrayList, el criterio es por
	 * @param legajo a buscar en el ArrayList docentes
	 * @return
	 */
	public static Docente buscarDocente(int legajo) {
		
		Predicate<Docente> filterLegajo = l -> l.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		
		if(docente.isPresent()) {
			return docente.get();
			
		}else {
			return null;
		}
	}

}
