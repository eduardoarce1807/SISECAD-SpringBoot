package upeu.sisecad.grupo5.oauth.models;

import java.util.List;

import lombok.Data;


@Data
public class Usuario {

	private Long id;
	private String username;
	private String password;
	private Boolean estado;
	private List<Rol> roles;
}
