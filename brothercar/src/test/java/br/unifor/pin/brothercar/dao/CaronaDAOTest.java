package br.unifor.pin.brothercar.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.brothercar.bussines.CaronasBO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class CaronaDAOTest {
	
	
	@Autowired
	private CaronasDAO caronaDAO;
	
	@Autowired
	private CaronasBO caronaBO;

	@Test
	public void testListaTodasCaronas() {
		
		Assert.assertNotNull(caronaDAO.listarTodos());
	}
	
	@Test
	public void testListaTodasCaronasBO() {
		
		Assert.assertNotNull(caronaBO.listarTodos());
	}

}
