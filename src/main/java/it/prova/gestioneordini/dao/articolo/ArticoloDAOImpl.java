package it.prova.gestioneordini.dao.articolo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		articoloInstance = entityManager.merge(articoloInstance);
	}

	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(articoloInstance);

	}

	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(articoloInstance));
	}

	@Override
	public Articolo getEagerCategorie(Long id) throws Exception {
		TypedQuery<Articolo> query = entityManager
				.createQuery("from Articolo a left join fetch a.categorie where a.id = ?1", Articolo.class);
		query.setParameter(1, id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	public Long findSumPrezziArticoliDataUnaCategoria(Categoria categoriaInput) throws Exception {
		Query q = entityManager.createNativeQuery(
				"select sum(a.prezzosingolo) from articolo a inner join articolo_categoria ac on a.id=ac.articolo_id inner join categoria c on ac.categoria_id=c.id where c.id= ?1");
		q.setParameter(1, categoriaInput.getId());
		BigDecimal result = (BigDecimal) q.getResultList().stream().findFirst().get();
		return result.longValue();
	}
	
	public Long findSumPrezziArticoliMarioRossi() throws Exception {
		Query q = entityManager.createNativeQuery(
				"select sum(a.prezzosingolo) from articolo a inner join ordine o on a.ordine_id=o.id where o.nomedestinatario like 'Mario Rossi'");
		BigDecimal result = (BigDecimal) q.getResultList().stream().findFirst().get();
		return result.longValue();
	}

}
