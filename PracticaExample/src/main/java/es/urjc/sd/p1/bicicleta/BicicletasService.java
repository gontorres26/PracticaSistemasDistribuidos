package es.urjc.sd.p1.bicicleta;

import java.util.List;
import java.util.Optional;

import es.urjc.sd.p1.repository.BicicletasRepository;

public class BicicletasService {

	private BicicletasRepository repository;

	public BicicletasService(BicicletasRepository repository){
		this.repository = repository;
	}

	public Optional<Bicicleta> findOne(Long id) {
		return repository.findById(id);
	}
	
	public boolean exist(Long id) {
		return repository.existsById(id);
	}

	public List<Bicicleta> findAll() {
		return repository.findAll();
	}

	public Bicicleta save(Bicicleta bici) {
		Bicicleta newBici = repository.save(bici);
		return newBici;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
