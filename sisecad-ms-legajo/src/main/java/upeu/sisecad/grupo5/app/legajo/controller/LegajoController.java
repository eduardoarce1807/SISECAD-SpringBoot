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

	@GetMapping
	public List<Legajo> listar() {
		return legajoService.findAll();
	}

	@GetMapping("/{id}")
	public Legajo findById(@PathVariable Integer id) {
		return legajoService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Legajo crear(@RequestBody Legajo legajo) {
		return legajoService.save(legajo);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Legajo editar(@RequestBody Legajo legajo, @PathVariable Integer id) {
		Legajo l = legajoService.findById(id);

		l.setDocente(legajo.getDocente());
		l.setIdCronograma(legajo.getIdCronograma());
		l.setFeLegajo(legajo.getFeLegajo());
		l.setIdConcurso(legajo.getIdConcurso());
		l.setIdEstado(legajo.getIdEstado());

		return legajoService.save(l);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		legajoService.deleteById(id);
	}

}
