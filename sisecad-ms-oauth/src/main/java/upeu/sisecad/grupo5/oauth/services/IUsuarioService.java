package upeu.sisecad.grupo5.oauth.services;

import upeu.sisecad.grupo5.oauth.models.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario, Long id);
	
}
