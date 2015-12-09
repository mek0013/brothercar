package br.unifor.pin.brothercar.manager.carona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.CaronasBO;
import br.unifor.pin.brothercar.bussines.OfertasBO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;
import br.unifor.pin.brothercar.utils.MessagesUtils;
import br.unifor.pin.brothercar.utils.Navigation;

@RequestScoped
@Component(value = "ofertarCarona")
@ManagedBean(name = "ofertarCarona")
public class OfertaCaronaManager {

	@Autowired
	private CaronasBO caronasBO;
	@Autowired
	private OfertasBO ofertasBO;

	private List<Caronas> caronas;
	private Caronas carona;
	private Integer quantidadeVagas;
	private Date dataCarona;
	private Date dataMinima = new Date();


	public String salva() {
		Ofertas oferta = new Ofertas();
		oferta.setCarona(carona);
		oferta.setDataHoraDeSaida(dataCarona);
		oferta.setQuantidadeVagas(quantidadeVagas);

		try {
			ofertasBO.salvarOferta(oferta);
			MessagesUtils.info("Oferta salva com sucesso!");
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			return Navigation.FRACASSO;
		}

		return Navigation.SUCESSO;
	}

	public String preparaOferta() {
		this.caronas = new ArrayList<Caronas>();
		for (Caronas carona : caronasBO.listarTodos()) {
			this.caronas.add(carona);
		}
		return Navigation.OFERTA;
	}

	public List<Caronas> getCaronas() {
		return caronas;
	}

	public void setCaronas(List<Caronas> caronas) {
		this.caronas = caronas;
	}

	public Caronas getCarona() {
		return carona;
	}

	public void setCarona(Caronas carona) {
		this.carona = carona;
	}

	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public Date getDataCarona() {
		return dataCarona;
	}

	public void setDataCarona(Date dataCarona) {
		this.dataCarona = dataCarona;
	}

	public Date getDataMinima() {
		return dataMinima;
	}

	public void setDataMinima(Date dataMinima) {
		this.dataMinima = dataMinima;
	}

	
	
}
