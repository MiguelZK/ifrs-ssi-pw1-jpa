package classes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.pedidos.Pedido;
import classes.util.JPAUtil;

public class PedidoDAO {

	private EntityManager em;
	
	public PedidoDAO() {}

	public boolean insert(Pedido pedido) {
		try {			
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean update(Pedido pedido) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(pedido);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public Pedido find(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Pedido pessoafisica = em.find(Pedido.class, id);
			return pessoafisica;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public boolean remove(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Pedido entity = em.find(Pedido.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public List<Pedido> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Pedido> query = em.createQuery("SELECT obj FROM Usuario obj", Pedido.class);
			List<Pedido> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
