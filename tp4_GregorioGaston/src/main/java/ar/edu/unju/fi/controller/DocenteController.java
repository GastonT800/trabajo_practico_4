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


import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		model.addAttribute("titulo", "Docentes Listado");
		
		return ("docenteList");
	}
	
	
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("docente", docente);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Docente");
		
		return "docenteForm";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
		
		ModelAndView modelView = new ModelAndView("docenteList");
		CollectionDocente.agregarDocente(docente);
		modelView.addObject("docentes", CollectionDocente.getDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo") short legajo) {
		
		Docente docenteEncontrado = new Docente();
		boolean edicion = true;
		docenteEncontrado = CollectionDocente.buscarDocente(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Modificar Docente");
		
		return "docenteForm";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		
		CollectionDocente.modificarDocente(docente);
		
		return "redirect:/docentes/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") short legajo) {
		
		CollectionDocente.eliminarDocente(legajo);
		
		return "redirect:/docentes/listado";
	}
}
