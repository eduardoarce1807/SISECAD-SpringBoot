package upeu.sisecad.grupo5.app.valor.controller;

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

import upeu.sisecad.grupo5.app.valor.entity.Valor;
import upeu.sisecad.grupo5.app.valor.service.ValorService;

@RestController
public class ValorController {

	@Autowired
	private ValorService valorService;

	@GetMapping
	public List<Valor> listar() {
		return valorService.findAll();
	}

	@GetMapping("/{id}")
	public Valor findById(@PathVariable Integer id) {
		return valorService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Valor crear(@RequestBody Valor valor) {
		return valorService.save(valor);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Valor editar(@RequestBody Valor valor, @PathVariable Integer id) {
		Valor v = valorService.findById(id);
		
		v.setIdTValor(valor.getIdTValor());
		v.setInValor(valor.getInValor());
		v.setEsValor(valor.isEsValor());
		
		return valorService.save(v);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		valorService.deleteById(id);
	}

}
