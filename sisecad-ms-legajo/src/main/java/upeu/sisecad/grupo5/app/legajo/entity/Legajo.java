package upeu.sisecad.grupo5.app.legajo.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_legajo")
public class Legajo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_legajo")
	private Integer id;
	//private Integer co_docente;
	@JoinColumn(name = "co_docente", referencedColumnName = "co_docente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Docente docente;
	@Column(name = "id_cronograma")
	private Integer idCronograma;
	@Column(name = "fe_legajo")
	private LocalDateTime feLegajo;
	@Column(name = "id_concurso")
	private Integer idConcurso;
	@Column(name = "id_estado")
	private Integer idEstado;
	
}
