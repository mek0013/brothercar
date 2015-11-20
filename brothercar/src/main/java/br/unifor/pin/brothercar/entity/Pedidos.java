package br.unifor.pin.brothercar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "ponto_escolhido")
	private String pontoEscolhido;
	
	@Column
	private Boolean statusDoPedido;
	
	@ManyToOne
	@JoinColumn(name="usuarios_id", nullable=false)
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name="ofertas_id", nullable = false)
	private Ofertas ofertas;

	public Integer getId() {
		return id;
	}

	public String getPontoEscolhido() {
		return pontoEscolhido;
	}



	public void setPontoEscolhido(String pontoEscolhido) {
		this.pontoEscolhido = pontoEscolhido;
	}



	public Boolean getStatusDoPedido() {
		return statusDoPedido;
	}



	public void setStatusDoPedido(Boolean statusDoPedido) {
		this.statusDoPedido = statusDoPedido;
	}



	public Usuarios getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}



	public Ofertas getOfertas() {
		return ofertas;
	}



	public void setOfertas(Ofertas ofertas) {
		this.ofertas = ofertas;
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
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", pontoEscolhido=" + pontoEscolhido
				+ ", statusDoPedido=" + statusDoPedido + "]";
	}

	
	
}
