package upeu.sisecad.grupo5.app.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import upeu.sisecad.grupo5.app.usuario.entity.Usuario;



@RepositoryRestResource(path="usuario")
public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	
	@RestResource(path = "buscar-username")
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerUsuario(@Param("username") String username);
}
