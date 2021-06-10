package upeu.sisecad.grupo5.app.cronograma.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	private Integer id_cronograma;
	private LocalDateTime fe_inicio;
	private LocalDateTime fe_fin;
	private String de_cronograma;
	private Integer id_t_cronograma;
	
}
