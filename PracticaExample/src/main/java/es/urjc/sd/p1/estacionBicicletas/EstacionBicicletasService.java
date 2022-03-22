package es.urjc.sd.p1.estacionBicicletas;

import java.util.List;
import java.util.Optional;

import es.urjc.sd.p1.repository.EstacionBicicletasRepository;


public class EstacionBicicletasService {

	private EstacionBicicletasRepository repository;
	

	public Optional<EstacionBicicletas> findOne(Long id) {
		return repository.findById(id);
	}
	
	public boolean exist(Long id) {
		return repository.existsById(id);
	}

	public List<EstacionBicicletas> findAll() {
		return repository.findAll();
	}

	public EstacionBicicletas save(EstacionBicicletas film) {
		EstacionBicicletas newEstacionBicicletas = repository.save(film);
		return newEstacionBicicletas;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
