package ar.edu.unju.fi.collections;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.Optional;
//import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	/**
	 * devuelve un arrayList de objetos de la clase Alumno
	 * @return
	 */
	public static List<Alumno> getAlumnos(){
		
//		if(alumnos.isEmpty()) {
//			
//			//alumnos.add(new Alumno(45613488, "Carla", "Gutierrez", "carlaG@gmail.com",(long)3884277345L, LocalDate.of(2000, 5, 12), "Av. Libertador 172","FH-1001"));
//			alumnos.add(new Alumno(45613488, "Carla", "Gutierrez", "carlaG@gmail.com",(long)3884277345L, LocalDate.of(2000, 5, 12), "Av. Libertador 172",1001));
//	        alumnos.add(new Alumno(33278457, "Eugenia", "Lobo", "eugeniaL@gmail.com",(long)3886789001L, LocalDate.of(1999, 8, 20), "Calle San Martín 436",1002));
//	        alumnos.add(new Alumno(53731591, "Marcos", "Castro", "marcosC@gmail.com",(long)3885512345L, LocalDate.of(1988, 2, 27), "Av. General Paz 377", 1003));
//	        alumnos.add(new Alumno(44613455, "Hector", "Zarate", "hectorZ@gmail.com",(long)3886252789L, LocalDate.of(1979, 7, 10), "Calle Aleman 1156", 1004));
//		
//	        return alumnos;
//	        
//		}else {
//			return alumnos;
//		}
//		
		 return alumnos;
	}
	
	/**
	 * agrega un objeto alumno al arrayList de alumnos
	 * @param alumno
	 */
	public static boolean agregarAlumno(Alumno alumno) {
		
		return alumnos.add(alumno) ? true : false;
	}
	
	/**
	 * elimina un objeto alumno del arrayList de alumnos
	 * @param dniAlumno
	 */
	public static void eliminarAlumno(int lu) {
		
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
			
			if(iterator.next().getLu()== lu) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * modifica un objeto alumno con los nuevos valores en
	 * @param alumno objeto con los valores de atributos modificados
	 */
	public static void modificarAlumno(Alumno alumno) throws Exception {
		
		boolean encontrado = false;
		
		try {
			for(Alumno alumn : alumnos) {
				
				if(alumn.getLu() == alumno.getLu()) {
					
					alumn.setNombre(alumno.getNombre());
					alumn.setApellido(alumno.getApellido());
					alumn.setEmail(alumno.getEmail());
					alumn.setTelefono(alumno.getTelefono());
					alumn.setFechaNacimiento(alumno.getFechaNacimiento());
					alumn.setDomicilio(alumno.getDomicilio());
					alumn.setLu(alumno.getLu());
					encontrado = true;
					
				}
			}
			if(!encontrado) {
				throw new Exception ("El alumno con Libreta Universitaria " + alumno.getLu() + " no existe");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		
		
	}
	
	/**
	 * busca un objeto alumno dentro del ArrayList, el criterio es por
	 * @param dni a buscar en el ArrayList alumnos
	 * @return
	 */
	public static Alumno buscarAlumno(int lu) {
		
//		Predicate<Alumno> filterLU = d -> d.getLu() == lu;
//		Optional<Alumno> alumno = alumnos.stream().filter(filterLU).findFirst();
//		if(alumno.isPresent()) 
//			return alumno.get();
//		else 
//			return null;
		return null;
	}

}
