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
@Table(name="caronas")
public class Caronas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nomeTrajeto;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id", nullable = false)
	private Usuarios usuario;
	
	@OneToMany(mappedBy = "carona",fetch=FetchType.EAGER)
	private List<PontoParada> pontosParada;
		
	public Integer getId() {
		return id;
	}

	public String getNomeTrajeto() {
		return nomeTrajeto;
	}

	public void setNomeTrajeto(String nomeTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<PontoParada> getPontosParada() {
		return pontosParada;
	}

	public void setPontosParada(List<PontoParada> pontosParada) {
		this.pontosParada = pontosParada;
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
		Caronas other = (Caronas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	

	
}
