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

import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.entity.Usuarios;


@Repository
public class PontoParadaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva(PontoParada pontoParada) {
		entityManager.persist(pontoParada);
	}
	
	public void atualizar(PontoParada pontoParada) {
		entityManager.merge(pontoParada);
	}
	
	public PontoParada buscarPorReferencia(String referencia){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PontoParada> criteriaQuery = criteriaBuilder.createQuery(PontoParada.class);
		Root<PontoParada> pontoParada = criteriaQuery.from(PontoParada.class);
		criteriaQuery.where(criteriaBuilder.equal(pontoParada.<String>get("referencia"), referencia));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return (PontoParada)query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PontoParada> listaPorReferencia(String logradouro){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PontoParada> criteriaQuery = criteriaBuilder.createQuery(PontoParada.class);
		Root<PontoParada> pontoParada = criteriaQuery.from(PontoParada.class);
		criteriaQuery.where(criteriaBuilder.equal(pontoParada.<String>get("logradouro"),logradouro));
		
		Query query = entityManager.createQuery(criteriaQuery);
		try {
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		}
	}
	
	
	public PontoParada buscaPorId(Integer id) {
		String jpql = "select p from ponto_parada p where p.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (PontoParada) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(PontoParada pontoParada) {
		entityManager.remove(pontoParada);
	}

}
