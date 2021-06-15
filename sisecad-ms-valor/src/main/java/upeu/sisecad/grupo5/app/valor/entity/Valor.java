package upeu.sisecad.grupo5.app.valor.entity;

import java.io.Serializable;

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
@Table(name = "tbl_valor")
public class Valor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_valor")
	private Integer id;
	@Column(name = "id_t_valor")
	private Integer idTValor;
	@Column(name = "in_valor")
	private Integer inValor;
	@Column(name = "es_valor")
	private boolean esValor;
	
}
