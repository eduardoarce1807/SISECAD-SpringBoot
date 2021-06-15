package upeu.sisecad.grupo5.app.nomina.service;

import java.util.List;

import upeu.sisecad.grupo5.app.nomina.entity.Nomina;

public interface NominaService {
	
	public List<Nomina> findAll();
	public Nomina findById(Integer id);
	public Nomina save(Nomina nomina);
	public void deleteById(Integer id);
	
}
