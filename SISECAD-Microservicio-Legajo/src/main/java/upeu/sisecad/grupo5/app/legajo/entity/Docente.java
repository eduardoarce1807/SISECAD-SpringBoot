package upeu.sisecad.grupo5.app.legajo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_docente")
public class Docente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id_persona;
	private String co_docente;
	private boolean es_ordinario;
	private Integer id_categoria;
	private Integer id_ua;

}
