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

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getCarreraPage(Model model) {
		
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo", "Carreras Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
		return ("carreraList");
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		
		boolean edicion=false;
		model.addAttribute("carrera", carreraDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Carrera");
		
		return "carreraForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, Model model) {
		
		ModelAndView modelView = new ModelAndView("carreraList");
		String mensaje;
		carreraDTO.setEstado(true);
		
		boolean exito = carreraService.save(carreraDTO);
		if(exito) {
			mensaje = "Carrera guardada con éxito!";
			
		}else {
			mensaje = "Carrera no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("carreras", carreraService.findAll());
		
		return modelView;
		
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") int codigo) {
		
		CarreraDTO carreraEncontradaDTO = carreraService.findByCod(codigo);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontradaDTO);
		model.addAttribute("titulo", "Modificar Carrera");
		
		return "carreraForm";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, Model model) {
		
		boolean exito = false;
		String mensaje = "";
		
		try {
			
			carreraService.edit(carreraDTO);
			mensaje = "La carrera con código " + carreraDTO.getCodigo() + " fue modificada con exito!";
			exito = true;
			
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo", "Carreras Listado");
		
		return "carreraList";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		
		carreraService.deleteByCod(codigo);
		
		return "redirect:/carrera/listado";
	}

}
