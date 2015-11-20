package br.unifor.pin.brothercar.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Pedidos;
import br.unifor.pin.brothercar.entity.Usuarios;



@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PedidosDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Pedidos pedido) {
		entityManager.persist(pedido);
	}
	
	public void atualizar(Pedidos pedido) {
		entityManager.merge(pedido);
	}
	
	public void excluir(Pedidos pedido) {
		entityManager.remove(pedido);
		
	}
	
	public Pedidos listarPorUsuario(Ofertas ofertas){
		String jpql = "select p from Pedidos p where p.statusDoPedido = false and p.ofertas = :ofertas";
		TypedQuery<Pedidos> query = entityManager.createQuery(jpql,Pedidos.class);
		query.setParameter("ofertas", ofertas);
		
		try {
			return query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
		
	}
	
	public List<Pedidos> listarPorUsuario(Usuarios usuario){
		String jpql = "select p from Pedidos p where p.usuario = :usuario";
		TypedQuery<Pedidos> query = entityManager.createQuery(jpql,Pedidos.class);
		query.setParameter("usuario", usuario);
		
		try {
			return query.getResultList();
		} catch(NoResultException e){
			return null;
		} 
		
	}
}
