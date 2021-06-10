package upeu.sisecad.grupo5.app.legajo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import upeu.sisecad.grupo5.app.legajo.dao.LegajoDao;
import upeu.sisecad.grupo5.app.legajo.entity.Docente;
import upeu.sisecad.grupo5.app.legajo.entity.Legajo;
import upeu.sisecad.grupo5.app.legajo.service.LegajoService;

@Service("restTemplate")
public class LegajoServiceImpl implements LegajoService {

	@Autowired
	private LegajoDao legajoDao;
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	@Transactional(readOnly = true)
	public List<Legajo> findAll() {
		
		List<Docente> docentes = Arrays.asList(clienteRest.getForObject("http://localhost:6060/api/docente/all", Docente[].class));
		
		return docentes.stream().map(d -> new Legajo(
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_legajo(),
				d,
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_cronograma(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getFe_legajo(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_concurso(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_estado()
				) ).collect(Collectors.toList());
		
		/*
		return docentes.stream().map(d -> new Legajo(
				Integer.valueOf(2),
				d,
				Integer.valueOf(1),
				new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
				Integer.valueOf(1),
				Integer.valueOf(1)
				)).collect(Collectors.toList());
		*/
		//return (List<Legajo>) legajoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Legajo findById(Integer id) {
		return legajoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Legajo save(Legajo legajo) {
		return legajoDao.save(legajo);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		legajoDao.deleteById(id);
	}

	@Override
	public Legajo findByCoDocente(String cod_docente) {
		return legajoDao.findByCoDocente(cod_docente).orElse(null);
	}
	
}

