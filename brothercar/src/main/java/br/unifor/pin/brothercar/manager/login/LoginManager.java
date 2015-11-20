/**
 * 
 */
package br.unifor.pin.brothercar.manager.login;

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

@RequestScoped
@Component(value = "login")
@ManagedBean(name = "login")
public class LoginManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private SegurancaTO seguranca;
	private Usuarios usuario = new Usuarios();
	private boolean existsMatricula;

	public String loggar() {
		Usuarios usuario = this.usuarioBO.loggar(this.usuario.getMatricula(),
				Encripta.encripta(this.usuario.getSenha()));
		this.usuario = new Usuarios();
		if (usuario != null) {
			seguranca.setUsuario(usuario);
			existsMatricula = true;
			MessagesUtils.info("Bem vindo "+usuario.getNome());
			return Navigation.SUCESSO;
		} else {
			existsMatricula = false;
			MessagesUtils.error("O Matricula ou a senha inseridos estão incorretos.");
			return Navigation.FRACASSO;
		}
	}
	
	public String preparaCadastro() {
		return Navigation.CADASTRO;
	}

	/**
	 * @return the usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the existsMatricula
	 */
	public boolean isExistsMatricula() {
		return existsMatricula;
	}

	/**
	 * @param existsMatricula
	 *            the existsMatricula to set
	 */
	public void setExistsMatricula(boolean existsMatricula) {
		this.existsMatricula = existsMatricula;
	}

}
