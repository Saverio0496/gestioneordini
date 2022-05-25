package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		categoriaInstance = entityManager.merge(categoriaInstance);
	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(categoriaInstance);
	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(categoriaInstance));
	}

	@Override
	public Categoria getEagerArticoli(Long id) throws Exception {
		TypedQuery<Categoria> query = entityManager
				.createQuery("select c from Categoria c left join fetch c.articoli where c.id = ?1", Categoria.class);
		query.setParameter(1, id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	public List<Categoria> findAllByOrdine(Ordine ordineInput) throws Exception {
		Query q = entityManager.createNativeQuery(
				"select distinct c.id from categoria c inner join articolo_categoria ac on c.id=ac.categoria_id inner join articolo a on ac.articolo_id=a.id inner join ordine o on a.ordine_id=o.id where o.id= ?1");
		q.setParameter(1, ordineInput.getId());
		return q.getResultList();
	}

}
