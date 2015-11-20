package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.OfertasDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.to.SegurancaTO;


@Loggable
@Service
public class OfertasBO {

	@Autowired
	private OfertasDAO ofertasDAO;
	
	@Autowired
	private SegurancaTO segurancaTO;
	
	public void salvarOferta(Ofertas oferta) {
		oferta.setStatus(true);
		ofertasDAO.salvar(oferta);
	}
	
	public List<Ofertas> listarOfertasPorUsuario() {
		return ofertasDAO.listarPorCarona(segurancaTO.getUsuario());
	}
	
	public List<Ofertas> listarOfertasDoUsuario() {
		return ofertasDAO.listaPorUsuario(segurancaTO.getUsuario());
	}
}
