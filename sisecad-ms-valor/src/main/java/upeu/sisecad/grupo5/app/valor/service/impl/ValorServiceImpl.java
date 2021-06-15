package upeu.sisecad.grupo5.app.valor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upeu.sisecad.grupo5.app.valor.dao.ValorDao;
import upeu.sisecad.grupo5.app.valor.entity.Valor;
import upeu.sisecad.grupo5.app.valor.service.ValorService;

@Service
public class ValorServiceImpl implements ValorService {

	@Autowired
	private ValorDao valorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Valor> findAll() {
		return (List<Valor>) valorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Valor findById(Integer id) {
		return valorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Valor save(Valor valor) {
		return valorDao.save(valor);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		valorDao.deleteById(id);
	}

}
