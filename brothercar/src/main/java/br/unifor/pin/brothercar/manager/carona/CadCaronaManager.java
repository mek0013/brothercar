package br.unifor.pin.brothercar.manager.carona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.CaronasBO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;
import br.unifor.pin.brothercar.utils.MessagesUtils;
import br.unifor.pin.brothercar.utils.Navigation;

@RequestScoped
@Component(value = "cadCarona")
@ManagedBean(name = "cadCarona")
public class CadCaronaManager {

	@Autowired
	private CaronasBO caronasBO;
	@Autowired
	private SegurancaTO segurancaTO;

	private List<PontoParada> listPontos = new ArrayList<PontoParada>();
	private PontoParada pontoParada;
	private String nomeTrajeto;
	private String logradouro;
	private String referencia;
	private Integer quantidadeVagas;
	private Date dataCarona;
	private boolean addPontos = true;

	public String salvar() {
		Caronas carona = new Caronas();
		Ofertas oferta = new Ofertas();
		carona.setNomeTrajeto(nomeTrajeto);
		oferta.setDataHoraDeSaida(dataCarona);
		oferta.setQuantidadeVagas(quantidadeVagas);

		try {
			caronasBO.salvarCarona(carona,listPontos,oferta);
			MessagesUtils.info("Carona salva com sucesso!");
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			return Navigation.FRACASSO;
		}

		return Navigation.SUCESSO;
	}

	public String preparaOferta() {
		return Navigation.OFERTA;
	}

	public void addPontos() {
		
		if (listPontos.size() <= 4 || listPontos.isEmpty()) {
			pontoParada = new PontoParada();
			pontoParada.setLogradouro(logradouro);
			pontoParada.setReferencia(referencia);
			listPontos.add(pontoParada);
			addPontos = true;
		} else {
			addPontos = false;
		}
		limparDados();
	}

	private void limparDados() {
		logradouro = "";
		referencia = "";

	}

	public List<PontoParada> getListPontos() {
		return listPontos;
	}

	public void setListPontos(List<PontoParada> listPontos) {
		this.listPontos = listPontos;
	}

	public PontoParada getPontoParada() {
		return pontoParada;
	}

	public void setPontoParada(PontoParada pontoParada) {
		this.pontoParada = pontoParada;
	}

	public String getNomeTrajeto() {
		return nomeTrajeto;
	}

	public void setNomeTrajeto(String nomeTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public boolean isAddPontos() {
		return addPontos;
	}

	public void setAddPontos(boolean addPontos) {
		this.addPontos = addPontos;
	}

	
}
