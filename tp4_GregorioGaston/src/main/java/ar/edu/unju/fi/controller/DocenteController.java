package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.imp.DocenteServicelmp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private DocenteDTO docenteDTO;
	
	@Autowired
	@Qualifier("docenteServiceMysql")
	private DocenteServicelmp docenteService;
	
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
	public ModelAndView guardarDocente(@Valid @ModelAttribute("docente") DocenteDTO docenteDTO, BindingResult result ,Model model) {
		
		ModelAndView modelView = new ModelAndView("docenteList");
		String mensaje = "Docente no se pudo guardar";
		boolean exito = false;
		if (result.hasErrors()) {
			model.addAttribute("docente", docenteDTO);
			modelView = new ModelAndView("docenteForm");
			List<FieldError> errors = result.getFieldErrors();
			model.addAttribute("errors", errors);
		} else {
			try {
				System.out.println("estoy acá 4");
				docenteDTO.setEstado(true);
				docenteService.save(docenteDTO);
				mensaje = "Docente guardado con éxito!";
				exito = true;
			} catch (Exception e) {
				System.out.println("estoy acá 5");
				model.addAttribute("formDocenteErrorMessage", e.getMessage());
				exito = false;
				mensaje = "Docente no se pudo guardar";
			}

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
			docenteDTO.setEstado(true);
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
	public String eliminarDocente(@PathVariable(value="legajo") int legajo) {
		
		docenteService.deleteById(legajo);
		
		return "redirect:/docente/listado";
	}
}
