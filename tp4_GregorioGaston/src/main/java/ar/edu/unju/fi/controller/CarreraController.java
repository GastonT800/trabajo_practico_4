package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
	
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarreraPage(Model model) {
		
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("titulo", "Carreras Listado");
		
		return ("carreraList");
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Carrera");
		
		return "carreraForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		
		ModelAndView modelView = new ModelAndView("carreraList");
		carrera.setEstado(true);
		CollectionCarrera.agregarCarrera(carrera);
		modelView.addObject("carreras", CollectionCarrera.getCarreras());
		
		return modelView;
		
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") int codigo) {
		
		Carrera carreraEncontrada = new Carrera();
		boolean edicion = true;
		carreraEncontrada = CollectionCarrera.buscarCarrera(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("titulo", "Modificar Carrera");
		
		return "carreraForm";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		
		CollectionCarrera.modificarCarrera(carrera);
		
		return "redirect:/carreras/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		
		CollectionCarrera.eliminarCarrera(codigo);
		
		return "redirect:/carreras/listado";
	}

}
