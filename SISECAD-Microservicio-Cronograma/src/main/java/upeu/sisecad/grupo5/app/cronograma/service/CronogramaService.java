package upeu.sisecad.grupo5.app.cronograma.service;

import java.util.List;

import upeu.sisecad.grupo5.app.cronograma.entity.Cronograma;

public interface CronogramaService {

	public List<Cronograma> findAll();
	public Cronograma findById(Integer id);
	public Cronograma save(Cronograma cronograma);
	public void deleteById(Integer id);
	
}
