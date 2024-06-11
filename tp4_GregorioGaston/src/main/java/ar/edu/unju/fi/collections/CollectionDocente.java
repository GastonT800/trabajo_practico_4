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
			
			docentes.add(new Docente((short) 1, "Lucas", "Gómez", "juanG@gmail.com",(long)3885723459L));
	        docentes.add(new Docente((short) 2, "María", "Pérez", "mariaP@gmail.com", (long)3884633902L));
	        docentes.add(new Docente((short) 3, "Jorge", "Luna", "jorgeL@gmail.com", (long)3885729439L));
	        docentes.add(new Docente((short) 4, "Valeria", "Corro", "valeriaC@gmail.com", (long)3885849402L));
	        
			return docentes;
			
		}else {
			return docentes;
		}
		
	}
	
	/**
	 * agrega un objeto docente al arrayList de docentes
	 * @param docente
	 */
	public static void agregarDocente(Docente docente){
		
		docentes.add(docente);
		
	}
	
	/**
	 * elimina un objeto docente del arrayList de docentes
	 * @param legajoDocente
	 */
	public static void eliminarDocente(short legajoDocente) {
		
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
	public static void modificarDocente(Docente docente) {
		
		for(Docente docent : docentes) {
			
			if(docent.getLegajo() == docente.getLegajo()) {
				
				docent.setNombre(docente.getNombre());
				docent.setApellido(docente.getApellido());
				docent.setEmail(docente.getEmail());
				docent.setTelefono(docente.getTelefono());
				
			}else {
				
				System.out.println("El LEGAJO no es valido");
			}
			
		}
		
	}
	
	/**
	 * busca un objeto docente dentro del ArrayList, el criterio es por
	 * @param legajo a buscar en el ArrayList docentes
	 * @return
	 */
	public static Docente buscarDocente(short legajo) {
		
		Predicate<Docente> filterLegajo = l -> l.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		
		if(docente.isPresent()) {
			return docente.get();
			
		}else {
			return null;
		}
	}

}
