package upeu.sisecad.grupo5.app.entrevista.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.sisecad.grupo5.app.entrevista.clients.CronogramaClienteRest;
import upeu.sisecad.grupo5.app.entrevista.dao.EntrevistaDao;
import upeu.sisecad.grupo5.app.entrevista.entity.Entrevista;
import upeu.sisecad.grupo5.app.entrevista.service.EntrevistaService;

@Service("serviceFeign")
public class EntrevistaServiceFeign implements EntrevistaService {

	@Autowired
	private CronogramaClienteRest clienteFeign;
	@Autowired
	private EntrevistaDao entrevistaDao;
	
	@Override
	public List<Entrevista> findAll() {
		
		return clienteFeign.all().stream().map(c -> new Entrevista(
				entrevistaDao.findByCronograma(c).orElse(null).getId(),
				c,
				entrevistaDao.findByCronograma(c).orElse(null).getEnEntrevista()
			)).collect(Collectors.toList());
		
	}

	@Override
	public Entrevista findById(Integer id) {
		
		return entrevistaDao.findById(id).orElse(null);
		
		/*
		return new Entrevista(
				entrevistaDao.findById(id).orElse(null).getId_entrevista(),
				clienteFeign.findById(id),
				entrevistaDao.findById(id).orElse(null).getEn_entrevista()
			);
		*/
	}

	@Override
	public Entrevista save(Entrevista entrevista) {
		return entrevistaDao.save(entrevista);
	}

	@Override
	public void deleteById(Integer id) {
		entrevistaDao.deleteById(id);
	}

	@Override
	public Entrevista findByIdCronograma(Integer id_cronograma) {
		return entrevistaDao.findByIdCronograma(id_cronograma).orElse(null);
	}
	
}
