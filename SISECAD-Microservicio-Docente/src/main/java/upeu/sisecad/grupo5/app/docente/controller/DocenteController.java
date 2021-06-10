package upeu.sisecad.grupo5.app.docente.controller;

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

import upeu.sisecad.grupo5.app.docente.entity.Docente;
import upeu.sisecad.grupo5.app.docente.service.DocenteService;

@RestController
public class DocenteController {

	@Autowired
	private DocenteService docenteService;

	@GetMapping("/all")
	public List<Docente> listar() {
		return docenteService.findAll();
	}

	@GetMapping("/all/{id}")
	public Docente findById(@PathVariable Integer id) {
		return docenteService.findById(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Docente crear(@RequestBody Docente docente) {
		return docenteService.save(docente);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Docente editar(@RequestBody Docente docente, @PathVariable Integer id) {
		Docente d = docenteService.findById(id);
		
		d.setId_persona(docente.getId_persona());
		d.setCo_docente(docente.getCo_docente());
		d.setEs_ordinario(docente.isEs_ordinario());
		d.setId_categoria(docente.getId_categoria());
		d.setId_ua(docente.getId_ua());
		
		return docenteService.save(d);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		docenteService.deleteById(id);
	}

}
