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

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.IAlumnoService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		
		model.addAttribute("alumnos", alumnoService.findAll());
		model.addAttribute("titulo", "Alumnos Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
		return ("alumnoList");
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevaAlumnoPage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("alumno", alumnoDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		
		return "alumnoForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO, Model model){
		
		ModelAndView modelView = new ModelAndView("alumnoList");
		String mensaje;
		boolean exito = alumnoService.save(alumnoDTO);
		if(exito) {
			mensaje = "Alumno guardado con éxito!";
			
		}else {
			mensaje = "Alumno no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("alumnos", alumnoService.findAll());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{lu}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="lu") int lu) {
		
		AlumnoDTO alumnoEncontradoDTO = alumnoService.findByLu(lu);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontradoDTO);
		model.addAttribute("titulo", "Modificar Alumno");
		
		return "alumnoForm";
		
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO, Model model) {
		
		boolean exito = false;
		String mensaje = "";
		try {
			alumnoService.edit(alumnoDTO);
			mensaje = "El alumno con Libreta Universitaria " + alumnoDTO.getLu() + " fue modificado con exito!";
			exito = true;
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("alumnos", alumnoService.findAll());
		model.addAttribute("titulo", "Alumnos Listado");
		
		return "alumnoList";
	}
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumno(@PathVariable(value="lu") int lu) {
		
		alumnoService.deleteByLu(lu);
		
		return "redirect:/alumno/listado";
	}

}
