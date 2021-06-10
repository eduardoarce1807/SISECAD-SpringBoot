package upeu.sisecad.grupo5.app.legajo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upeu.sisecad.grupo5.app.legajo.entity.Legajo;
import upeu.sisecad.grupo5.app.legajo.service.LegajoService;

@RestController
public class LegajoController {

	@Autowired
	@Qualifier("serviceFeign")
	private LegajoService legajoService;

	@GetMapping("/all")
	public List<Legajo> listar() {
		return legajoService.findAll();
	}

	@GetMapping("/all/{id}")
	public Legajo findById(@PathVariable Integer id) {
		return legajoService.findById(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Legajo crear(@RequestBody Legajo legajo) {
		return legajoService.save(legajo);
	}

	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Legajo editar(@RequestBody Legajo legajo, @PathVariable Integer id) {
		Legajo l = legajoService.findById(id);

		l.setCo_docente(legajo.getCo_docente());
		l.setId_cronograma(legajo.getId_cronograma());
		l.setFe_legajo(legajo.getFe_legajo());
		l.setId_concurso(legajo.getId_concurso());
		l.setId_estado(legajo.getId_estado());

		return legajoService.save(l);

	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		legajoService.deleteById(id);
	}

}