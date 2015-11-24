package br.unifor.pin.brothercar.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.brothercar.bussines.UsuarioBO;
import br.unifor.pin.brothercar.dao.UsuarioDAO;
import br.unifor.pin.brothercar.entity.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class UsuarioDAOTest {
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Test
	public void testSalvar() throws Exception {
		
		Usuarios usuario = new Usuarios();
		usuario.setNome("neto");
		usuario.setSenha("123456");
		usuario.setEmail("neto@gmail.com");
		usuario.setAtivo(false);
		usuario.setMatricula("1410455");
		usuarioDao.salvar(usuario);
		
		Assert.assertNotNull(usuario.getId());
		System.out.println(usuario.getId());
		
		
	}
	
	@Test
	public void testListaPorNome(){
		List<Usuarios> usuarios = usuarioDao.listarPorNome("neto");
		Assert.assertEquals(1, usuarios.size());
	}

}
