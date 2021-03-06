package upeu.sisecad.grupo5.app.entrevista.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import upeu.sisecad.grupo5.app.entrevista.entity.Cronograma;

@FeignClient(name = "ms-cronograma")
@RequestMapping("/api/cronograma")
public interface CronogramaClienteRest {

	@GetMapping
	public List<Cronograma> all();
	
	@GetMapping("/{id}")
	public Cronograma findById(@PathVariable Integer id);
	
	@PostMapping
	public Cronograma save(@RequestBody Cronograma cronograma);
	
	@PutMapping("/{id}")
	public Cronograma edit(@RequestBody Cronograma cronograma, @PathVariable Integer id);
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id);
	
}