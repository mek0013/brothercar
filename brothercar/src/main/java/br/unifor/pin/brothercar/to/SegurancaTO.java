/**
 * 
 */
package br.unifor.pin.brothercar.to;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.utils.Navigation;

/**
 * @author patrick.cunha
 * @since 07/05/2015
 */
@Component(value = "segurancaTO")
@ManagedBean(name = "segurancaTO")
@SessionScoped
public class SegurancaTO implements Serializable {

	private static final long serialVersionUID = -9069250861713212366L;
	private Logger logger = Logger.getLogger(SegurancaTO.class);
	
	private Usuarios usuario;

	public boolean isAutenticado() {
		return usuario != null;
	}
	
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}
	
	public String logout() throws LoginException {
		logger.info("logout do sistema");
		this.getRequest().getSession(false).invalidate();
		this.usuario = null;

		return Navigation.SAIR;
	}
	
	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

}
