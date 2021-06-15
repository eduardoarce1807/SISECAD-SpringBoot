package upeu.sisecad.grupo5.app.legajo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import upeu.sisecad.grupo5.app.legajo.entity.Docente;
import upeu.sisecad.grupo5.app.legajo.entity.Legajo;

public interface LegajoDao extends CrudRepository<Legajo, Integer> {
	
	Optional<Legajo> findByDocente(Docente docente);
	
}
