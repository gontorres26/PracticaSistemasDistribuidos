package es.urjc.sd.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.sd.p1.bicicleta.Bicicleta;
public interface BicicletasRepository extends JpaRepository<Bicicleta, Long>
{
}