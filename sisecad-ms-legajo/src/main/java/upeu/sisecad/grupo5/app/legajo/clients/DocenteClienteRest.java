package upeu.sisecad.grupo5.app.legajo.clients;

import java.util.List;

//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import upeu.sisecad.grupo5.app.legajo.entity.Docente;

@FeignClient(name = "ms-docente")
@RequestMapping("/api/docente")
public interface DocenteClienteRest {

	@GetMapping
	public List<Docente> all();
	
	@GetMapping("/{id}")
	public Docente findById(@PathVariable Integer id);
	
	@PostMapping
	public Docente save(@RequestBody Docente docente);
	
	@PutMapping("/{id}")
	public Docente edit(@RequestBody Docente docente, @PathVariable Integer id);
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id);
	
}
