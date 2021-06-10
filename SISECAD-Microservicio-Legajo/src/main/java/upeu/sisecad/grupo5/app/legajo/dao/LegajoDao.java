package upeu.sisecad.grupo5.app.legajo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import upeu.sisecad.grupo5.app.legajo.entity.Legajo;

public interface LegajoDao extends CrudRepository<Legajo, Integer> {

	@Query(value ="select * from tbl_legajo where co_docente = ?1", nativeQuery = true)
	Optional<Legajo> findByCoDocente(String co_docente);
	
}
