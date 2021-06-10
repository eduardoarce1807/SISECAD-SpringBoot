package upeu.sisecad.grupo5.app.entrevista.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import upeu.sisecad.grupo5.app.entrevista.entity.Entrevista;

public interface EntrevistaDao extends CrudRepository<Entrevista, Integer> {

	@Query(value ="select * from tbl_entrevista where id_cronograma = ?1", nativeQuery = true)
	Optional<Entrevista> findByIdCronograma(Integer id_cronograma);
	
}
