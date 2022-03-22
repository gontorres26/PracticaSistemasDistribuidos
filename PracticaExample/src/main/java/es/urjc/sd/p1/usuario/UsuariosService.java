package es.urjc.sd.p1.usuario;

import java.util.List;
import java.util.Optional;

import es.urjc.sd.p1.repository.UsuariosRepository;

public class UsuariosService {
	private UsuariosRepository repository;

	public UsuariosService(UsuariosRepository repository){
		this.repository = repository;
	}

	public Optional<Usuario> findOne(Long id) {
		return repository.findById(id);
	}
	
	public boolean exist(Long id) {
		return repository.existsById(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario save(Usuario user) {
		Usuario newUser = repository.save(user);
		return newUser;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
