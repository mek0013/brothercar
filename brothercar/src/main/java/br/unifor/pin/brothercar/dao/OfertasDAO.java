package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Usuarios;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class OfertasDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Ofertas oferta) {
		entityManager.persist(oferta);
	}

	public void atualizar(Ofertas oferta) {
		entityManager.merge(oferta);
	}

	public void excluir(Ofertas oferta) {
		entityManager.remove(oferta);

	}

	@SuppressWarnings("unchecked")
	public List<Ofertas> listarPorCarona(Usuarios usuario){
		String jpql = "select o from Ofertas o join o.carona c where o.status = true and c.usuario != :usuarios";
		Query query = entityManager.createQuery(jpql,Ofertas.class);
		query.setParameter("usuarios", usuario);
		
		try {
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Ofertas> listaPorUsuario(Usuarios usuario) {
		String jpql = "select o from Ofertas o join o.carona c where o.status = true and c.usuario = :usuarios";
		Query query = entityManager.createQuery(jpql,Ofertas.class);
		query.setParameter("usuarios", usuario);
		
		try {
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		} 
	}
}
