package es.urjc.sd.p1.controller;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import es.urjc.sd.p1.bicicleta.Bicicleta;
import es.urjc.sd.p1.estacionBicicletas.EstacionBicicletas;
import es.urjc.sd.p1.repository.BicicletasRepository;
import es.urjc.sd.p1.repository.EstacionBicicletasRepository;
import es.urjc.sd.p1.repository.UsuariosRepository;
import es.urjc.sd.p1.usuario.Usuario;

@Component
@Profile("local")
public class BaseDeDatos {

	@Autowired
	private EstacionBicicletasRepository EstacionBicicletasRepositorio;
	
	@Autowired
	private BicicletasRepository BicicletasRepositorio;
	
	@Autowired
	private UsuariosRepository UsuariosRepositorio;

	@PostConstruct
	public void populateDBEstacionesBicicletas() {
		EstacionBicicletasRepositorio.saveAll(Arrays.asList(new EstacionBicicletas(21, 34F, 21L, 7),
				new EstacionBicicletas(22, 34F, 21L, 7), new EstacionBicicletas(23, 34F, 21L, 7)

		));

	} 

	@PostConstruct
	public void populateDBBicicletas() {
		BicicletasRepositorio.saveAll(Arrays.asList(new Bicicleta("Modelo 1"),
				new Bicicleta("Modelo 2"), new Bicicleta("Modelo 3")

		));

	} 
	
	@PostConstruct
	public void populateDBUsuarios() {
		UsuariosRepositorio.saveAll(Arrays.asList(new Usuario("Juan", "Contraseña1"),
				new Usuario("Pedro", "contraseña2"), new Usuario("Pepe", "Contraseña3")

		));

	} 
}
