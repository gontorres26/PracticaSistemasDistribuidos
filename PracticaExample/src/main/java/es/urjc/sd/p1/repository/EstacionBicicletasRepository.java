package es.urjc.sd.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.sd.p1.estacionBicicletas.EstacionBicicletas;
public interface EstacionBicicletasRepository extends JpaRepository<EstacionBicicletas, Long>
{
}