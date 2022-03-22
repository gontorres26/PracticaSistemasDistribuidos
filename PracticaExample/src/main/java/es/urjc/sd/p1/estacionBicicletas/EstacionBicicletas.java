package es.urjc.sd.p1.estacionBicicletas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.urjc.sd.p1.bicicleta.Bicicleta;

@Entity
public class EstacionBicicletas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int numeroDeSerie;
	private float longitud;
	private float latitud;
	private int capacidadDeBicicletas;
	private EstadoEstacionBicicletas estado;
	private Date fechaInstalacion;
	private ArrayList<Bicicleta> bicicletas;

	public EstacionBicicletas() {
	};

	public EstacionBicicletas(int numeroDeSerie, float longitud, float latitud, int capacidadDeBicicletas) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.longitud = longitud;
		this.latitud = latitud;
		this.capacidadDeBicicletas = capacidadDeBicicletas;
		this.fechaInstalacion = Date.valueOf(LocalDate.now());
		this.estado = EstadoEstacionBicicletas.ACTIVA;
		this.bicicletas = new ArrayList<>();
	}


	public ArrayList<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}

	public EstadoEstacionBicicletas getEstado() {
		return estado;
	}

	public void setEstado(EstadoEstacionBicicletas estado) {
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public int getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(int numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public int getCapacidadDeBicicletas() {
		return capacidadDeBicicletas;
	}

	public void setCapacidadDeBicicletas(int capacidadDeBicicletas) {
		this.capacidadDeBicicletas = capacidadDeBicicletas;
	}

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

}
