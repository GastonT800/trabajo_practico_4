package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/principal")
public class MainController {
	
	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		model.addAttribute("titulo", "Inicio | Facultad de Humanidades y Ciencias Sociales");
		return "index";
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	@GetMapping("/biblioteca")
	public String getBibliotecaPage() {
		return "biblioteca";
	}
	
	@GetMapping("/calendario_academico")
	public String getCalendarioAcadenicoPage() {
		return "calendario_academico";
	}
	
	 
	@GetMapping("/acerca_de")
	public String getAcercaDePage() {
		return "acerca_de";
	}
	
	@GetMapping("/carreras")
	public String getCarrerasPage() {
		return "carreras";
	}
	
	@GetMapping("/noticias")
	public String getNoticiasPage() {
		return "noticias";
	}
	
	
	@GetMapping("/contacto")
	public String getContactoPage() {
		return "contacto";
	}
	*/
}
