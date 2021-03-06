package upeu.sisecad.grupo5.app.cronograma.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "tbl_cronograma")
public class Cronograma implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cronograma")
	private Integer id;
	@Column(name = "fe_inicio")
	private LocalDateTime feInicio;
	@Column(name = "fe_fin")
	private LocalDateTime feFin;
	@Column(name = "de_cronograma")
	private String deCronograma;
	@Column(name = "id_t_cronograma")
	private Integer idTCronograma;
	
}
