package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.PedidosDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Pedidos;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;

@Loggable
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PedidosBO {

	@Autowired
	private PedidosDAO pedidosDAO;
	
	@Autowired
	private SegurancaTO segurancaTO;
	
	public void salvar(Ofertas oferta, String pontoEscolhido) {
		Pedidos pedido = new Pedidos();
		pedido.setOfertas(oferta);
		pedido.setPontoEscolhido(pontoEscolhido);
		pedido.setStatusPedido("AGUARDANDO");
		pedido.setUsuario(segurancaTO.getUsuario());
		pedidosDAO.salvar(pedido);
		
	}
	
	public Pedidos listaPorOferta(Ofertas oferta) {
		return pedidosDAO.listarPorStatus(oferta);
	}
	
	public List<Pedidos> listarPorUsuario() {
		return pedidosDAO.listarPorUsuario(segurancaTO.getUsuario());
	}
	
	public void confirmaPedido(Pedidos pedido) throws BOException {
		pedido.setStatusPedido("ACEITOR");
		pedidosDAO.atualizar(pedido);
	}
	
	public void recusarPedido(Pedidos pedido) throws BOException {
		pedido.setStatusPedido("RECUSADO");
		pedidosDAO.atualizar(pedido);
	}
}
