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
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarreraPage(Model model) {
		
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("titulo", "Carreras Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
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
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		
		ModelAndView modelView = new ModelAndView("carreraList");
		String mensaje;
		carrera.setEstado(true);
		
		boolean exito = CollectionCarrera.agregarCarrera(carrera);
		if(exito) {
			mensaje = "Carrera guardada con éxito!";
			
		}else {
			mensaje = "Carrera no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
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
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		
		boolean exito = false;
		String mensaje = "";
		
		try {
			
			CollectionCarrera.modificarCarrera(carrera);
			mensaje = "La carrera con código " + carrera.getCodigo() + " fue modificada con exito!";
			exito = true;
			
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("titulo", "Carreras Listado");
		
		return "carreraList";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		
		CollectionCarrera.eliminarCarrera(codigo);
		
		return "redirect:/carrera/listado";
	}

}
