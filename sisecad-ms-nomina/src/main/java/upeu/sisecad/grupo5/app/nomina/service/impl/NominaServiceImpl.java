package upeu.sisecad.grupo5.app.nomina.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.sisecad.grupo5.app.nomina.dao.NominaDao;
import upeu.sisecad.grupo5.app.nomina.entity.Nomina;
import upeu.sisecad.grupo5.app.nomina.service.NominaService;

@Service
public class NominaServiceImpl implements NominaService {

	@Autowired
	private NominaDao nominaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Nomina> findAll() {
		return (List<Nomina>) nominaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Nomina findById(Integer id) {
		return nominaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Nomina save(Nomina nomina) {
		return nominaDao.save(nomina);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		nominaDao.deleteById(id);
	}

}
