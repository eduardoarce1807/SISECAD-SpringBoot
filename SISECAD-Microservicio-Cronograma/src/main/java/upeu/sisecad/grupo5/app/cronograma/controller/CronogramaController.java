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

	@GetMapping("/all")
	public List<Cronograma> listar() {
		return cronogramaService.findAll();
	}

	@GetMapping("/all/{id}")
	public Cronograma findById(@PathVariable Integer id) {
		return cronogramaService.findById(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Cronograma crear(@RequestBody Cronograma cronograma) {
		return cronogramaService.save(cronograma);
	}

	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cronograma editar(@RequestBody Cronograma cronograma, @PathVariable Integer id) {
		Cronograma c = cronogramaService.findById(id);

		c.setFe_inicio(cronograma.getFe_inicio());
		c.setFe_fin(cronograma.getFe_fin());
		c.setDe_cronograma(cronograma.getDe_cronograma());
		c.setId_t_cronograma(cronograma.getId_t_cronograma());

		return cronogramaService.save(c);

	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		cronogramaService.deleteById(id);
	}

}
