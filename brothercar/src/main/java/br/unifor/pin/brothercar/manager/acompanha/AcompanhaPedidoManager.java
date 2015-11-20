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
import br.unifor.pin.brothercar.utils.Navigation;


@RequestScoped
@Component(value = "acomPedido")
@ManagedBean(name = "acomPedido")
public class AcompanhaPedidoManager {

	@Autowired
	private PedidosBO pedidosBO;
	
	private List<Pedidos> pedidos;
	
	public String preparaAcompanhaPedido() {
		this.setPedidos(new ArrayList<Pedidos>());
		
		this.pedidos = pedidosBO.listarPorUsuario();
		return Navigation.ACOMPANHA_PEDIDO;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
