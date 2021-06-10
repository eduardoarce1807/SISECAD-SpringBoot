package upeu.sisecad.grupo5.app.legajo.service;

import java.util.List;

import upeu.sisecad.grupo5.app.legajo.entity.Legajo;

public interface LegajoService {

	public List<Legajo> findAll();
	public Legajo findById(Integer id);
	public Legajo save(Legajo legajo);
	public void deleteById(Integer id);
	public Legajo findByCoDocente(String co_docente);
	
}
