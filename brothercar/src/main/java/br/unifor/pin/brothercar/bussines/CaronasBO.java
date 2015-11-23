package br.unifor.pin.brothercar.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.CaronasDAO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;

@Loggable
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CaronasBO {

	@Autowired
	private CaronasDAO caronasDAO;
	@Autowired
	private PontoParadaBO pontoParadaBO;
	@Autowired
	private OfertasBO ofertasBO;
	@Autowired
	private SegurancaTO segurancaTO;
	
	public void salvarCarona(Caronas carona,List<PontoParada> pontos,Ofertas oferta) throws BOException{
		
		carona.setUsuario(segurancaTO.getUsuario());
		caronasDAO.salvar(carona);
		carona.setPontosParada(new ArrayList<PontoParada>());
		for (PontoParada ponto : pontos) {
			carona.getPontosParada().add(ponto);
			ponto.setCarona(carona);
			pontoParadaBO.salvar(ponto);
		}
		
		oferta.setCarona(carona);
		ofertasBO.salvarOferta(oferta);
		
	}
	
	public List<Caronas> listarTodos() {
		List<Caronas> caronas  = caronasDAO.listarTodos();
		
		return caronas;
	}
	
	
}
