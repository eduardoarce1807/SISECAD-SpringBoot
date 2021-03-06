package upeu.sisecad.grupo5.app.entrevista.service;

import java.util.List;

import upeu.sisecad.grupo5.app.entrevista.entity.Entrevista;

public interface EntrevistaService {

	public List<Entrevista> findAll();
	public Entrevista findById(Integer id);
	public Entrevista save(Entrevista entrevista);
	public void deleteById(Integer id);
	public Entrevista findByIdCronograma(Integer id_cronograma);
	
}
