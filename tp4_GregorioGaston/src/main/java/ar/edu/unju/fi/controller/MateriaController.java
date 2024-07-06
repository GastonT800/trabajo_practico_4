package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private MateriaDTO materiaDTO;
	
	@Autowired
	private DocenteDTO docenteDTO;
	
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	@Qualifier("materiaServiceCollection")
	private IMateriaService materiaService;
	
	@Autowired
	@Qualifier("docenteServiceMysql")
	private IDocenteService docenteService;
	
	@Autowired
	@Qualifier("carreraServiceMysql")
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getMateriaPage(Model model) {
		
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("titulo", "Materias Listado");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		
		return ("materiaList");
		
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {

		boolean edicion=false;
		model.addAttribute("materia", materiaDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Materia");
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("carreras", carreraService.findAll());
		
		return "materiaForm";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO, Model model) {
		
		ModelAndView modelView = new ModelAndView("materiaList");
		String mensaje;
		carreraDTO = carreraService.findByCod(materiaDTO.getCarrera().getCodigo());
		docenteDTO = docenteService.findById(materiaDTO.getDocente().getLegajo());
		materiaDTO.setCarrera(carreraDTO);
		materiaDTO.setDocente(docenteDTO);
		//boolean exito = materiaService.save(materiaDTO);
		boolean exito= false;
		if(exito) {
			mensaje = "Materia guardada con éxito!";
			
		}else {
			mensaje = "Materia no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("materias", materiaService.findAll());
		
		return modelView;
		
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		
		boolean edicion = true;
		MateriaDTO materiaEncontrada = materiaService.findByCod(codigo);

		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada);
		model.addAttribute("titulo", "Modificar Materia");
		model.addAttribute("docentes", docenteService.findAll());
		model.addAttribute("carreras", carreraService.findAll());
		
		return "materiaForm";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO, Model model) {
		
		carreraDTO = carreraService.findByCod(materiaDTO.getCarrera().getCodigo());
		docenteDTO = docenteService.findById(materiaDTO.getDocente().getLegajo());
		materiaDTO.setCarrera(carreraDTO);
		materiaDTO.setDocente(docenteDTO);
		boolean exito = false;
		String mensaje = "";
		
		try {
			
			materiaService.edit(materiaDTO);
			mensaje = "La materia con código" + materiaDTO.getCodigo() + " fue modificada con exito!";
			exito = true;
			
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("titulo", "Materias Listado");
		
		return "materiaList";
		
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		
		materiaService.deleteByCod(codigo);
		
		return "redirect:/materia/listado";
	}

}
