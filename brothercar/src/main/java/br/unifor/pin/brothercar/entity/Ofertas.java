package br.unifor.pin.brothercar.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="ofertas")
public class Ofertas {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false)
	private String statusOferta;
	
	@Column(name = "data_hora_saida")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraDeSaida;
	
	@Column
	private Integer quantidadeVagas;
	
	@ManyToOne
	@JoinColumn(name = "caronas_id")
	private Caronas carona;

	public Integer getId() {
		return id;
	}

	public String getStatusOferta() {
		return statusOferta;
	}

	public void setStatusOferta(String statusOferta) {
		this.statusOferta = statusOferta;
	}

	public Caronas getCarona() {
		return carona;
	}


	public void setCarona(Caronas carona) {
		this.carona = carona;
	}

	public Date getDataHoraDeSaida() {
		return dataHoraDeSaida;
	}


	public void setDataHoraDeSaida(Date dataHoraDeSaida) {
		this.dataHoraDeSaida = dataHoraDeSaida;
	}


	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}


	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ofertas other = (Ofertas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ofertas [id=" + id + ", statusOferta=" + statusOferta + ", dataHoraDeSaida=" + dataHoraDeSaida
				+ ", quantidadeVagas=" + quantidadeVagas + "]";
	}


	


	
	
	
}
