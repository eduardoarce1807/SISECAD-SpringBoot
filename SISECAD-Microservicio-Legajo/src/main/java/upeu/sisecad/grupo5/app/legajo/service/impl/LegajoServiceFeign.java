package upeu.sisecad.grupo5.app.legajo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.sisecad.grupo5.app.legajo.clients.DocenteClienteRest;
import upeu.sisecad.grupo5.app.legajo.dao.LegajoDao;
import upeu.sisecad.grupo5.app.legajo.entity.Legajo;
import upeu.sisecad.grupo5.app.legajo.service.LegajoService;

@Service("serviceFeign")
public class LegajoServiceFeign implements LegajoService {

	@Autowired
	private DocenteClienteRest clienteFeign;
	@Autowired
	private LegajoDao legajoDao;
	
	@Override
	public List<Legajo> findAll() {
		return clienteFeign.all().stream().map(d -> new Legajo(
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_legajo(),
				d,
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_cronograma(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getFe_legajo(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_concurso(),
				legajoDao.findByCoDocente(d.getCo_docente()).orElse(null).getId_estado()
				) ).collect(Collectors.toList());
	}

	@Override
	public Legajo findById(Integer id) {
		return new Legajo(
				legajoDao.findById(id).orElse(null).getId_legajo(),
				clienteFeign.findById(id),
				legajoDao.findById(id).orElse(null).getId_cronograma(),
				legajoDao.findById(id).orElse(null).getFe_legajo(),
				legajoDao.findById(id).orElse(null).getId_concurso(),
				legajoDao.findById(id).orElse(null).getId_estado()
				);
	}

	@Override
	public Legajo save(Legajo legajo) {
		return legajoDao.save(legajo);
	}

	@Override
	public void deleteById(Integer id) {
		legajoDao.deleteById(id);
	}

	@Override
	public Legajo findByCoDocente(String co_docente) {
		return legajoDao.findByCoDocente(co_docente).orElse(null);
	}

	
	
}
