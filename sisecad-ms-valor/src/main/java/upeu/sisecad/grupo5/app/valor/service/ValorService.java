package upeu.sisecad.grupo5.app.valor.service;

import java.util.List;

import upeu.sisecad.grupo5.app.valor.entity.Valor;

public interface ValorService {

	public List<Valor> findAll();
	public Valor findById(Integer id);
	public Valor save(Valor valor);
	public void deleteById(Integer id);
	
}
