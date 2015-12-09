package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.OfertasDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;


@Loggable
@Service
public class OfertasBO {

	@Autowired
	private OfertasDAO ofertasDAO;
	
	@Autowired
	private SegurancaTO segurancaTO;
	
	public void salvarOferta(Ofertas oferta) throws BOException{
		oferta.setStatusOferta("DISPONIVEL");
		ofertasDAO.salvar(oferta);
	}
	
	public void atualizarOferta() {
		List<Ofertas> ofertas = ofertasDAO.listaPorQuantidade();
		for (Ofertas oferta : ofertas) {
			oferta.setStatusOferta("INDISPONIVEL");
			ofertasDAO.atualizar(oferta);
		}
	}
	
	public List<Ofertas> listarOfertasPorUsuario() {
		return ofertasDAO.listarPorUsuario(segurancaTO.getUsuario());
	}
	
	public List<Ofertas> listarOfertasDoUsuario() {
		return ofertasDAO.listaDoUsuario(segurancaTO.getUsuario());
	}
	
	public void atualizar(Ofertas oferta) {
		ofertasDAO.atualizar(oferta);
	}
}
