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

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private DocenteDTO docenteDTO;
	
	@Autowired
	private IDocenteService docenteService;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("titulo", "Docentes Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
		return ("docenteList");
	}
	
	
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("docente", docenteDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Docente");
		
		return "docenteForm";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") DocenteDTO docenteDTO, Model model) {
		
		ModelAndView modelView = new ModelAndView("docenteList");
		String mensaje;
		boolean exito = docenteService.save(docenteDTO);
		if(exito) {
			mensaje = "Docente guardado con éxito!";
			
		}else {
			mensaje = "Docente no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("docentes", docenteService.findAll());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo") short legajo) {
		
		boolean edicion = true;
		DocenteDTO docenteEncontradoDTO = docenteService.findById(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontradoDTO);
		model.addAttribute("titulo", "Modificar Docente");
		
		return "docenteForm";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") DocenteDTO docenteDTO, Model model) {
		
		boolean exito = false;
		String mensaje = "";
		try {
			
			docenteService.edit(docenteDTO);
			mensaje = "El docente con legajo " + docenteDTO.getLegajo() + " fue modificada con exito!";
			exito = true;		
					
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("docentes", docenteService.findAll() );
		model.addAttribute("titulo", "Docentes Listado");
		
		return "docenteList";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") short legajo) {
		
		docenteService.deleteById(legajo);
		
		return "redirect:/docente/listado";
	}
}
