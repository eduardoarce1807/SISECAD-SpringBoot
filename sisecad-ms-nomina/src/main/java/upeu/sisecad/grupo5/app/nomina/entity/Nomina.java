package upeu.sisecad.grupo5.app.nomina.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_nomina")
public class Nomina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nomina")
	private Integer id;
	@Column(name = "id_t_nomina")
	private Integer idTNomina;
	@Column(name = "no_nomina")
	private String noNomina;
	@Column(name = "fe_creacion")
	private Date feCreacion;
	
}
