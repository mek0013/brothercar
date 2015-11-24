package br.unifor.pin.brothercar.bussines;

import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.bussines.EncriptaTest;



public class UsuarioBOTest {
	
	public void salvarTest() {
		Usuarios usuario = new Usuarios();
		usuario.setNome("maycon");
		usuario.setEmail("maycom@gmail.com");
		usuario.setMatricula("121314");
		usuario.setSenha(EncriptaTest.stubsEncripta("12345"));
		usuario.setAdministrador(false);
		
		System.out.println(usuario.getSenha());
	}
	
}
