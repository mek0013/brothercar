package br.unifor.pin.brothercar.manager.principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.manager.usuario.AtualizaUsuarioManager;
import br.unifor.pin.brothercar.to.SegurancaTO;
import br.unifor.pin.brothercar.utils.Navigation;


@RequestScoped
@Component(value = "principal")
@ManagedBean(name = "principal")
public class PrincipalManager {

	
	@Autowired
	private AtualizaUsuarioManager atualizaUser;
	
	@Autowired
	private SegurancaTO segurancaTO;
	
	public String preparaCadTrajeto() {
		return Navigation.CADASTRO;
	}
	
	public String preparaAtualizarUser() {

		this.atualizaUser.preparaAtualizar(this.segurancaTO.getUsuario());

		return Navigation.ATUALIZA;
	}
	
	public String preparaOferta() {
		return Navigation.OFERTA;
	}
	
}
