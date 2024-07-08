package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	@Qualifier("carreraServiceMysql")
	private ICarreraService carreraService;
	
	@Autowired
	@Qualifier("alumnoServiceMysql")
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
		model.addAttribute("carreras", carreraService.findAll());
		
		return "alumnoForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result, Model model) {
		
		ModelAndView modelView = new ModelAndView();
		
		 if (alumnoDTO.getCarrera().getCodigo() == -1) {
		        result.rejectValue("carrera.codigo", "error.carrera", "Seleccione una carrera válida"); // crea un error si no selecciono ningun docente
		 }
		
		if (result.hasErrors()) {
			model.addAttribute("carreras", carreraService.findAll());
			modelView.setViewName("alumnoForm");
		}else {
			modelView = new ModelAndView("alumnoList");
			String mensaje;
			boolean exito=false;
			alumnoDTO.setEstado(true);
			if(alumnoService.save(alumnoDTO) != null) {
				mensaje = "Alumno guardado con éxito!";
				exito = true;
			}else {
				mensaje = "Alumno no se pudo guardar";
			}
			modelView.addObject("exito", exito);
			modelView.addObject("mensaje", mensaje);
			modelView.addObject("alumnos", alumnoService.findAll());
		}
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
	public String modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Modificar Alumno");
			model.addAttribute("edicion", true);
			return "alumnoForm";
			
		}else  {
			boolean exito = false;
			
			String mensaje = "";
			try {
				alumnoDTO.setEstado(true);
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
	}
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumno(@PathVariable(value="lu") int lu) {
		
		alumnoService.deleteByLu(lu);
		
		return "redirect:/alumno/listado";
	}

}
