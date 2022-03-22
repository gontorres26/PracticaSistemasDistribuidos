package es.urjc.sd.p1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.sd.p1.usuario.Usuario;
public interface UsuariosRepository extends JpaRepository<Usuario, Long>
{
}
