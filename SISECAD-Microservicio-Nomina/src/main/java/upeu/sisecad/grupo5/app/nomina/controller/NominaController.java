package upeu.sisecad.grupo5.app.nomina.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upeu.sisecad.grupo5.app.nomina.entity.Nomina;
import upeu.sisecad.grupo5.app.nomina.service.NominaService;

@RestController
public class NominaController {

	@Autowired
	private NominaService nominaService;

	@GetMapping("/all")
	public List<Nomina> listar() {
		return nominaService.findAll();
	}

	@GetMapping("/all/{id}")
	public Nomina findById(@PathVariable Integer id) {
		return nominaService.findById(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Nomina crear(@RequestBody Nomina nomina) {
		return nominaService.save(nomina);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Nomina editar(@RequestBody Nomina nomina, @PathVariable Integer id) {
		Nomina n = nominaService.findById(id);
		
		n.setId_t_nomina(nomina.getId_t_nomina());
		n.setNo_nomina(nomina.getNo_nomina());
		n.setFe_creacion(nomina.getFe_creacion());
		
		return nominaService.save(n);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		nominaService.deleteById(id);
	}

}
