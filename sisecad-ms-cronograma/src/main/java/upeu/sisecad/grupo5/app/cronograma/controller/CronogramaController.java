package upeu.sisecad.grupo5.app.cronograma.controller;

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

import upeu.sisecad.grupo5.app.cronograma.entity.Cronograma;
import upeu.sisecad.grupo5.app.cronograma.service.CronogramaService;

@RestController
public class CronogramaController {

	@Autowired
	private CronogramaService cronogramaService;

	@GetMapping
	public List<Cronograma> listar() {
		return cronogramaService.findAll();
	}

	@GetMapping("/{id}")
	public Cronograma findById(@PathVariable Integer id) {
		return cronogramaService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cronograma crear(@RequestBody Cronograma cronograma) {
		return cronogramaService.save(cronograma);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cronograma editar(@RequestBody Cronograma cronograma, @PathVariable Integer id) {
		Cronograma c = cronogramaService.findById(id);

		c.setFeInicio(cronograma.getFeInicio());
		c.setFeFin(cronograma.getFeFin());
		c.setDeCronograma(cronograma.getDeCronograma());
		c.setIdTCronograma(cronograma.getIdTCronograma());

		return cronogramaService.save(c);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		cronogramaService.deleteById(id);
	}

}
