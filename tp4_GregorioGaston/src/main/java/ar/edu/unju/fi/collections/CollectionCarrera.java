package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	
	private static List<Carrera> carreras =  new ArrayList<Carrera>();
	
	/**
	 * devuelve un arrayList de objetos de la clase Carrea
	 * @return
	 */
	public static List<Carrera> getCarreras(){
		
		if(carreras.isEmpty()){
			
			carreras.add(new Carrera(1, "Licenciatura en Antropologia",(short) 5 ,true));
			carreras.add(new Carrera(2, "Profesorado en Letras",(short) 5, false));
			carreras.add(new Carrera(3, "Tecnicatura y Lic. en Turismo",(short) 4, true));
			
			return carreras;
			
		}else {
			return carreras;
		}
		
	}
	
	/**
	 * agrega un objeto carrera al arrayList de carreras
	 * @param carrera
	 */
	public static void agregarCarrera(Carrera carrera) {
		
		carreras.add(carrera);
	}
	
	/**
	 * elimina un objeto carrera del arrayList de carreras
	 * @param codigoCarrera
	 */
	public static void eliminarCarrera(int codigoCarrera) {
		
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			
			if(iterator.next().getCodigo()== codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * modifica un objeto carrera con los nuevos valores enviado en 
	 * @param carrera objeto con los valores de atributos modificados
	 */
	public static void modificarCarrera(Carrera carrera) {
		
		for(Carrera carre : carreras ) {
			
			if(carre.getCodigo() == carrera.getCodigo()) {
				
				carre.setNombre(carrera.getNombre());
				carre.setCantAnios(carrera.getCantAnios());
				carre.setEstado(carrera.isEstado());
				
			}else {
				System.out.println("El CÓDIGO no es valido");
			}
		}
	}
	
	/**
	 * busca un objeto carrera dentro del ArrayList, el criterio es por
	 * @param codigo a buscar en el ArrayList carreras
	 * @return
	 */
	public static Carrera buscarCarrera(int codigo) {
		
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		
		if(carrera.isPresent()) {
			return carrera.get();
			
		}else {
			return null;
		}	
	}

}
