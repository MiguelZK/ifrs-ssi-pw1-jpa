package classes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.contatos.Telefone;
import classes.util.JPAUtil;

public class TelefoneDAO {

	private EntityManager em;
	
	public TelefoneDAO() {}

	public boolean insert(Telefone telefone) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(telefone);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean update(Telefone telefone) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(telefone);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public Telefone find(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Telefone pessoafisica = em.find(Telefone.class, id);
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
			Telefone entity = em.find(Telefone.class, id);
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

	public List<Telefone> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Telefone> query = em.createQuery("SELECT obj FROM Usuario obj", Telefone.class);
			List<Telefone> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
