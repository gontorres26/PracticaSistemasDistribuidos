package es.urjc.sd.p1.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.sd.p1.bicicleta.Bicicleta;
import es.urjc.sd.p1.bicicleta.EstadoBicicleta;
import es.urjc.sd.p1.estacionBicicletas.EstacionBicicletas;
import es.urjc.sd.p1.estacionBicicletas.EstadoEstacionBicicletas;
import es.urjc.sd.p1.repository.BicicletasRepository;
import es.urjc.sd.p1.repository.EstacionBicicletasRepository;
import es.urjc.sd.p1.repository.UsuariosRepository;
import es.urjc.sd.p1.usuario.EstadoUsuario;
import es.urjc.sd.p1.usuario.Usuario;

@Controller
public class Controlador {
	@Autowired
	private BicicletasRepository postBicicleta;
	@Autowired
	private EstacionBicicletasRepository postEstacionBicicletas;
	@Autowired
	private UsuariosRepository postUsuarios;
	
	/* ------------------------------------ PAGINA PRINCIPAL -------------------------------------------- */
	
	@GetMapping("/principal")
	public String greeting(Model model) {

		return "Pagina_Principal";
	}

	/* ------------------------------------ USUARIOS -------------------------------------------- */	
	
	@GetMapping("/gestionUsuarios")
	public String gestionUsuarios(Model model) {
		List<Usuario> postList = postUsuarios.findAll();
		model.addAttribute("postList", postList);
		return "Gestion_Usuario";
	}
	
	@GetMapping("/nuevoUsuario")
	public String nuevoUsuario(Model model, Usuario user) {
		postUsuarios.save(user);
		List<Usuario> postList = postUsuarios.findAll();
		model.addAttribute("postList", postList);
		return "Gestion_Usuario";
	}
	
	@GetMapping("/detallesUsuario")
	public String detallesUsuario(Model model, @PathVariable long id) {
		Optional<Usuario> maybeUser = postUsuarios.findById(id);
		if (maybeUser.isPresent()) {
		Usuario user = maybeUser.get();
		model.addAttribute("identificador", user.getId());
		model.addAttribute("nombreUsuario", user.getNombreCompleto());
		model.addAttribute("fechaAlta", user.getFechaDeAlta());
		model.addAttribute("estado", user.getEstado());
		}
		return "Detalles_Usuario";
	}
	
	@GetMapping("/modificarUsuario/{id}")
	public String modificarUsuario(Model model, @PathVariable long id, @RequestParam String contraseña,
			@RequestParam String nombre, @RequestParam EstadoUsuario estado) {
		Optional<Usuario> maybeUser = postUsuarios.findById(id);
		Usuario user = maybeUser.get();
		user.setNombreCompleto(nombre);
		user.setContraseña(contraseña);
		user.setEstado(estado);
		return "Gestion_Usuario";
	}
	
	@GetMapping("/bajaUsuario/{id}")
	public String bajaUsuario(Model model, @PathVariable long id) {
		postUsuarios.deleteById(id);
		return "Gestion_Usuario";
	}
	
	/* ------------------------------------ BICICLETAS -------------------------------------------- */
	
	@GetMapping("/gestionBicicletas")
	public String gestionBicicletas(Model model) {
		List<String> listaNumeroSerie = new LinkedList<>();
		List<Long> listaID = new LinkedList<>();
		List<Bicicleta> postList = postBicicleta.findAll();
		for (Bicicleta bici : postList) {
			listaNumeroSerie.add(bici.getNumeroDeSerie());
			listaID.add(bici.getId());
		}
		model.addAttribute("listaNumeroSerie", listaNumeroSerie);
		model.addAttribute("listaID", listaID);

		return "Pagina_Principal_Gestion_Bicicletas";
	}
	
	@GetMapping("/altaBicicleta")
	public String altaBicicleta(Model model, @RequestParam String modelo) {
		postBicicleta.save(new Bicicleta(modelo));
		return "Pagina_Principal_Gestion_Estaciones_Bicicletas";
	}
	
	@GetMapping("/bajaBicicleta")
	public String bajaBicicleta(Model model, @RequestParam long id) {
		Optional<Bicicleta> maybeBicicleta = postBicicleta.findById(id);
		Bicicleta bicicleta = maybeBicicleta.get();
		bicicleta.setEstado(EstadoBicicleta.BAJA);
		return "Pagina_Principal_Gestion_Estaciones_Bicicletas";
	}
	
	
	
	/* ------------------------------------ ESTACIONES DE BICICLETAS -------------------------------------------- */
	
	@GetMapping("/gestionEstacionesBicicletas")
	public String gestionEstacionesBicicletas(Model model) {
		List<Integer> listaNumeroSerie = new LinkedList<>();
		List<Long> listaID = new LinkedList<>();
		List<EstacionBicicletas> postList = postEstacionBicicletas.findAll();
		for (EstacionBicicletas estacion : postList) {
			listaNumeroSerie.add(estacion.getNumeroDeSerie());
			listaID.add(estacion.getId());
		}
		model.addAttribute("listaNumeroSerie", listaNumeroSerie);
		model.addAttribute("listaID", listaID);

		return "Pagina_Principal_Gestion_Estaciones_Bicicletas";
	}

	@GetMapping("/altaEstacionBicicleta")
	public String altaEstacionBicicleta(Model model, @RequestParam int numeroDeSerie, @RequestParam long longitud,
			@RequestParam long latitud, @RequestParam int capacidadDeBicicletas) {
		postEstacionBicicletas.save(new EstacionBicicletas(numeroDeSerie, longitud, latitud, capacidadDeBicicletas));
		return "Pagina_Principal_Gestion_Estaciones_Bicicletas";
	}
	
	@GetMapping("/bajaEstacionBicicleta")
	public String bajaEstacionBicicleta(Model model, @RequestParam long id) {
		Optional<EstacionBicicletas> maybeEstacionBicicletas = postEstacionBicicletas.findById(id);
		EstacionBicicletas estacionBicicletas = maybeEstacionBicicletas.get();
		ArrayList<Bicicleta> bicicletas = estacionBicicletas.getBicicletas();
		for(Bicicleta bici:bicicletas) {
			bici.setEstado(EstadoBicicleta.SIN_BASE);
		}
		estacionBicicletas.setEstado(EstadoEstacionBicicletas.INACTIVA);
		postEstacionBicicletas.deleteById(id); //??????????
		return "Pagina_Principal_Gestion_Estaciones_Bicicletas";
	}

	
}
