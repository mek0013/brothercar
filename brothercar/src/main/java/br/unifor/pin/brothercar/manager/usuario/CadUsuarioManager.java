package br.unifor.pin.brothercar.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.bussines.UsuarioBO;
import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.utils.Encripta;
import br.unifor.pin.brothercar.utils.MessagesUtils;
import br.unifor.pin.brothercar.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadUsuario")
@Component(value="cadUsuario")
public class CadUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private String nome;
	private String email;
	private String senha;
	private String matricula;
	
	public String salvar(){
		Usuarios usuario = new Usuarios();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setMatricula(matricula);
		usuario.setSenha(Encripta.encripta(senha));
		usuario.setAdministrador(false);
		try {
			usuarioBO.salvar(usuario);
		} catch (BOException e) {
			MessagesUtils.error(e.getMessage());
			this.limpaDados();
			return Navigation.FRACASSO;
		}
		MessagesUtils.info("Usuário salvo com sucesso!");
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.CADASTRO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.email = "";
		this.senha = "";
		this.matricula = "";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
