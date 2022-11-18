package classes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.pessoas.PessoaFisica;
import classes.util.JPAUtil;

public class PessoaFisicaDAO {

	private EntityManager em;
	
	public PessoaFisicaDAO() {}

	public boolean insert(PessoaFisica pessoaFisica) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(pessoaFisica);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean update(PessoaFisica pessoaFisica) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(pessoaFisica);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public PessoaFisica find(int id) {
		try {
			em = JPAUtil.getEntityManager();
			PessoaFisica pessoafisica = em.find(PessoaFisica.class, id);
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
			PessoaFisica entity = em.find(PessoaFisica.class, id);
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

	public List<PessoaFisica> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<PessoaFisica> query = em.createQuery("SELECT obj FROM Usuario obj", PessoaFisica.class);
			List<PessoaFisica> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
