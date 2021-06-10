package upeu.sisecad.grupo5.app.entrevista.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

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

import upeu.sisecad.grupo5.app.entrevista.entity.Entrevista;
import upeu.sisecad.grupo5.app.entrevista.service.EntrevistaService;

@RestController
public class EntrevistaController {

	@Autowired
	@Qualifier("serviceFeign")
	private EntrevistaService entrevistaService;

	@GetMapping("/all")
	public List<Entrevista> listar() {
		return entrevistaService.findAll();
	}

	@GetMapping("/all/{id}")
	public Entrevista findById(@PathVariable Integer id) {
		return entrevistaService.findById(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Entrevista crear(@RequestBody Entrevista entrevista) {
		return entrevistaService.save(entrevista);
	}

	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Entrevista editar(@RequestBody Entrevista entrevista, @PathVariable Integer id) {
		Entrevista e = entrevistaService.findById(id);

		e.setId_entrevista(entrevista.getId_entrevista());
		e.setId_cronograma(entrevista.getId_cronograma());
		e.setEn_entrevista(entrevista.getEn_entrevista());

		return entrevistaService.save(e);

	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		entrevistaService.deleteById(id);
	}

}
