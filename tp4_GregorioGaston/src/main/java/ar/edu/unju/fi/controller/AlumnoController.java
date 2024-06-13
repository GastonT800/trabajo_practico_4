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

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;


@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	private Alumno alumno;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		
		model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
		model.addAttribute("titulo", "Alumnos Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
		return ("alumnoList");
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevaAlumnoPage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		
		return "alumnoForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno, Model model){
		
		ModelAndView modelView = new ModelAndView("alumnoList");
		String mensaje;
		boolean exito = CollectionAlumno.agregarAlumno(alumno);
		if(exito) {
			mensaje = "Alumno guardado con éxito!";
			
		}else {
			mensaje = "Alumno no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("alumnos", CollectionAlumno.getAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{dni}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="dni") int dni) {
		
		Alumno alumnoEncontrado = new Alumno();
		boolean edicion = true;
		alumnoEncontrado = CollectionAlumno.buscarAlumno(dni);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar Alumno");
		
		return "alumnoForm";
		
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno, Model model) {
		
		boolean exito = false;
		String mensaje = "";
		
		try {
			
			CollectionAlumno.modificarAlumno(alumno);
			mensaje = "El alumno con el DNI " + alumno.getDni() + " fue modificado con exito!";
			exito = true;
			
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
		model.addAttribute("titulo", "Alumnos Listado");
		
		return "alumnoList";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable(value="dni") int dni) {
		
		CollectionAlumno.eliminarAlumno(dni);
		
		return "redirect:/alumnos/listado";
	}

}
