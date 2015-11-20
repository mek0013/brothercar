package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.PontoParadaDAO;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;


@Loggable
@Service
public class PontoParadaBO {

	@Autowired
	private PontoParadaDAO pontoParadaDao;
	
	public void salvar(PontoParada pontoParada) throws BOException {
		
		PontoParada pontoParadaComReferencia = pontoParadaDao.buscarPorReferencia(pontoParada.getReferencia());
		
		if (pontoParadaComReferencia != null) {
			throw new BOException("Ponto de parada ja existe!");
			
		}
		pontoParadaDao.salva(pontoParada);
	}
	
	public List<PontoParada> listaPorReferencia(String logradouro) {
		return pontoParadaDao.listaPorReferencia(logradouro);
	}
	
	public void atualizar(PontoParada pontoParada) {
		pontoParadaDao.atualizar(pontoParada);
		
	}
	
	public void excluir(PontoParada pontoParada) {
		pontoParadaDao.excluir(pontoParada);
		
	}
}
