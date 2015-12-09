package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Usuarios;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CaronasDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Caronas caronas) {
		entityManager.persist(caronas);
	}
	
	public void atualizar(Caronas caronas) {
		entityManager.merge(caronas);
	}
	
	public void excluir(Caronas caronas) {
		entityManager.remove(caronas);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Caronas> listarTodos() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Caronas> criteriaQuery = criteriaBuilder.createQuery(Caronas.class);
		Root<Caronas> carona = criteriaQuery.from(Caronas.class);
		
		Query query = entityManager.createQuery(criteriaQuery.select(carona));
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Caronas> listaPorUsuario(Usuarios usuario) {
		String jpql = "select c from Caronas c where c.usuario = :usuarios";
		Query query = entityManager.createQuery(jpql,Caronas.class);
		query.setParameter("usuarios", usuario);
		
		try {
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public Caronas buscar(Integer id) {
		return entityManager.find(Caronas.class, id);
	}
	
}
