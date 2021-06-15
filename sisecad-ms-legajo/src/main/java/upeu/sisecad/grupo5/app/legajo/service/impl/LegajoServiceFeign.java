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
				legajoDao.findByDocente(d).orElse(null).getId(),
				d,
				legajoDao.findByDocente(d).orElse(null).getIdCronograma(),
				legajoDao.findByDocente(d).orElse(null).getFeLegajo(),
				legajoDao.findByDocente(d).orElse(null).getIdConcurso(),
				legajoDao.findByDocente(d).orElse(null).getIdEstado()
				) ).collect(Collectors.toList());
	}

	@Override
	public Legajo findById(Integer id) {
		return new Legajo(
				legajoDao.findById(id).orElse(null).getId(),
				clienteFeign.findById(id),
				legajoDao.findById(id).orElse(null).getIdCronograma(),
				legajoDao.findById(id).orElse(null).getFeLegajo(),
				legajoDao.findById(id).orElse(null).getIdConcurso(),
				legajoDao.findById(id).orElse(null).getIdEstado()
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
	
}
