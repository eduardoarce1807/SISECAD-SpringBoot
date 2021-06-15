package upeu.sisecad.grupo5.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import upeu.sisecad.grupo5.oauth.models.Usuario;

@FeignClient(name = "ms-usuario")
public interface UsuarioFeignClient {
	
	@GetMapping("/api/usuario/usuario/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
}
