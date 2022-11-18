package classes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.pedidos.ItemPedido;
import classes.util.JPAUtil;

public class ItemPedidoDAO {

	private EntityManager em;
	
	public ItemPedidoDAO() {}

	public boolean insert(ItemPedido itemPedido) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(itemPedido);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean update(ItemPedido itemPedido) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(itemPedido);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public ItemPedido find(int id) {
		try {
			em = JPAUtil.getEntityManager();
			ItemPedido pessoafisica = em.find(ItemPedido.class, id);
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
			ItemPedido entity = em.find(ItemPedido.class, id);
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

	public List<ItemPedido> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<ItemPedido> query = em.createQuery("SELECT obj FROM Usuario obj", ItemPedido.class);
			List<ItemPedido> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
