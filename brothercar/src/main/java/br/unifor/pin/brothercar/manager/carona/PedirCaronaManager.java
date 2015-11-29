package br.unifor.pin.brothercar.manager.carona;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.OfertasBO;
import br.unifor.pin.brothercar.bussines.PedidosBO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.utils.Navigation;


@RequestScoped
@Component(value = "pedirCarona")
@ManagedBean(name = "pedirCarona")
public class PedirCaronaManager {
	
	@Autowired
	private OfertasBO ofertasBO;
	@Autowired
	private PedidosBO pedidosBO;
	
	private List<Ofertas> ofertas;
    private List<Ofertas> filteredOfertas;
    
    public String preparaPedir(){
    	ofertasBO.atualizarOferta();
    	this.ofertas = ofertasBO.listarOfertasPorUsuario();
		return Navigation.PEDIR;
	}
    
    
    public String salvar(Ofertas oferta, PontoParada ponto) {
    	String pontoEscolhido = ponto.getLogradouro() + " em frente ao " + ponto.getReferencia();
    	
		if (oferta != null) {
			pedidosBO.salvar(oferta, pontoEscolhido);
			
			return Navigation.SUCESSO;
		} else {
			return Navigation.FRACASSO;
		}
	}
    

	public List<Ofertas> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Ofertas> ofertas) {
		this.ofertas = ofertas;
	}


	public List<Ofertas> getFilteredOfertas() {
		return filteredOfertas;
	}


	public void setFilteredOfertas(List<Ofertas> filteredOfertas) {
		this.filteredOfertas = filteredOfertas;
	}
	
	

}
