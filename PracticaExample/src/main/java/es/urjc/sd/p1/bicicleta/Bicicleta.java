package es.urjc.sd.p1.bicicleta;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bicicleta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 16)
	private String numeroDeSerie = "AAAA";
	private String modelo;
	private Date fechaDeAlta;
	private EstadoBicicleta estado;
	private long idEstacion;

	public Bicicleta() {
	};

	public Bicicleta(String modelo) {
		super();
		this.modelo = modelo;
		this.estado = EstadoBicicleta.SIN_BASE;
		this.fechaDeAlta = Date.valueOf(LocalDate.now());
		this.numeroDeSerie = numeroDeSerie.concat(Integer.toString(getRNDInteger(1, 10000)));
		this.idEstacion = 0;
	}

	public long getEstacion() {
		return idEstacion;
	}

	public void setEstacion(long estacion) {
		this.idEstacion = estacion;
	}

	private Integer getRNDInteger(int i, int j) {
		return (int) Math.floor(Math.random() * (j - i) + i);
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public long getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public EstadoBicicleta getEstado() {
		return estado;
	}

	public void setEstado(EstadoBicicleta estado) {
		this.estado = estado;
	}

}
