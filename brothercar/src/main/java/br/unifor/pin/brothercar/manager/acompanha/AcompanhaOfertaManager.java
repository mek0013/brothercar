package br.unifor.pin.brothercar.manager.acompanha;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.OfertasBO;
import br.unifor.pin.brothercar.bussines.PedidosBO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Pedidos;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.utils.MessagesUtils;
import br.unifor.pin.brothercar.utils.Navigation;


@RequestScoped
@Component(value = "acomOferta")
@ManagedBean(name = "acomOferta")
public class AcompanhaOfertaManager {

	@Autowired
	private PedidosBO pedidosBO;
	@Autowired
	private OfertasBO ofertasBO;
	
	private List<Pedidos> pedidos;
	private List<Ofertas> ofertas;
	
	public String preparaAcompanhaOferta() {
		this.ofertas = new ArrayList<Ofertas>();
		this.pedidos = new ArrayList<Pedidos>();
		
		ofertasBO.atualizarOferta();
		this.ofertas = ofertasBO.listarOfertasDoUsuario();
		for (Ofertas oferta : ofertas) {
			this.pedidos.add(pedidosBO.listaPorOferta(oferta));
		}
		return Navigation.ACOMPANHA_OFERTA;
	}
	
	public String aceitar(Pedidos pedido) {
		try {
			Ofertas oferta = pedido.getOfertas();
			oferta.setQuantidadeVagas(oferta.getQuantidadeVagas()-1);
			ofertasBO.atualizar(oferta);
			pedidosBO.confirmaPedido(pedido);
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			return Navigation.FRACASSO;
		}
		MessagesUtils.info("Pedido Aceito!");
		
		return Navigation.SUCESSO;
	}
	
	public String recusar(Pedidos pedido) {
		try {
			pedidosBO.recusarPedido(pedido);
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			return Navigation.FRACASSO;
		}
		MessagesUtils.info("Pedido não foi aceito!");
		
		return Navigation.SUCESSO;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Ofertas> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Ofertas> ofertas) {
		this.ofertas = ofertas;
	}
	
	
}
