package classes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.pessoas.PessoaFisica;
import classes.pessoas.PessoaJuridica;
import classes.util.JPAUtil;

public class PessoaJuridicaDAO {

	private EntityManager em;
	
	public PessoaJuridicaDAO() {}

	public boolean insert(PessoaJuridica pessoaJuridica) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(pessoaJuridica);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean update(PessoaJuridica pessoaJuridica) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(pessoaJuridica);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}
	
	public PessoaJuridica find(int id) {
		try {
			em = JPAUtil.getEntityManager();
			PessoaJuridica pessoafisica = em.find(PessoaJuridica.class, id);
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
			PessoaJuridica entity = em.find(PessoaJuridica.class, id);
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

	public List<PessoaJuridica> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<PessoaJuridica> query = em.createQuery("SELECT obj FROM PessoaJuridica obj", PessoaJuridica.class);
			List<PessoaJuridica> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
	
	public List<PessoaJuridica> findAll(String nome) {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<PessoaJuridica> query = em.createQuery(
					"SELECT obj FROM PessoaJuridica obj WHERE obj.razaoSocial = :nome", PessoaJuridica.class);
			query.setParameter("nome", nome);
			List<PessoaJuridica> clientes = query.getResultList();
			return clientes;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
}
