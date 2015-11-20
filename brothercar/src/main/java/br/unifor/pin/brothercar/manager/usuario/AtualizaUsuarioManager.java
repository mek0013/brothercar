package br.unifor.pin.brothercar.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.UsuarioBO;
import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.to.SegurancaTO;
import br.unifor.pin.brothercar.utils.Encripta;
import br.unifor.pin.brothercar.utils.MessagesUtils;
import br.unifor.pin.brothercar.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name = "atualizaUsuario")
@Component(value = "atualizaUsuario")
public class AtualizaUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private Usuarios usuarioAtual;
	@Autowired
	private SegurancaTO segurancaTO;

	public String atualizar() {
		usuarioBO.atualizar(usuarioAtual);
		MessagesUtils.info("Usuário atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public void preparaAtualizar(Usuarios usuarios) {
		
		usuarioAtual = usuarios;
		
	}
	
	public String excluir() {
		this.usuarioBO.excluir(usuarioAtual);
		
		return Navigation.EXCLUIR;
	}
	
	public void limparDados(){
		usuarioAtual.setNome("");
		usuarioAtual.setEmail("");
		usuarioAtual.setSenha("");
		usuarioAtual.setAtivo(false);
		
	}

	public Usuarios getUsuarioAtual() {
		return usuarioAtual;
	}
	
	public void setUsuarioAtual(Usuarios usuarioSelecionado) {
		this.usuarioAtual = usuarioSelecionado;
	}
	
}
