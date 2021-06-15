package upeu.sisecad.grupo5.app.cronograma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.sisecad.grupo5.app.cronograma.dao.CronogramaDao;
import upeu.sisecad.grupo5.app.cronograma.entity.Cronograma;
import upeu.sisecad.grupo5.app.cronograma.service.CronogramaService;

@Service
public class CronogramaServiceImpl implements CronogramaService {

	@Autowired
	private CronogramaDao cronogramaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cronograma> findAll() {
		return (List<Cronograma>) cronogramaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cronograma findById(Integer id) {
		return cronogramaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cronograma save(Cronograma cronograma) {
		return cronogramaDao.save(cronograma);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		cronogramaDao.deleteById(id);
	}
	
}
