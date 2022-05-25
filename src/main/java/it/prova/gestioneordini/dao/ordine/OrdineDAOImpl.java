package it.prova.gestioneordini.dao.ordine;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		ordineInstance = entityManager.merge(ordineInstance);
	}

	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(ordineInstance);
	}

	@Override
	public void delete(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ordineInstance));
	}

	@Override
	public Ordine getEagerArticoli(Long id) throws Exception {
		TypedQuery<Ordine> query = entityManager
				.createQuery("select o from Ordine o left join fetch o.articoli where o.id = ?1", Ordine.class);
		query.setParameter(1, id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	public List<Ordine> findAllByCategoria(Categoria categoriaInput) throws Exception {
		Query q = entityManager.createNativeQuery(
				"select distinct o.id from ordine o inner join articolo a on o.id=a.ordine_id inner join articolo_categoria ac on ac.articolo_id=a.id inner join categoria c on ac.categoria_id=c.id where c.id= ?1");
		q.setParameter(1, categoriaInput.getId());
		return q.getResultList();
	}

	public Ordine findIlPiuRecenteDataUnaCategoria(Categoria categoriaInput) throws Exception {
		TypedQuery<Ordine> query = entityManager.createQuery(
				"select o from Ordine o join o.articoli a join a.categorie c where c.id = ?1 order by o.dataSpedizione desc", Ordine.class);
		return query.setParameter(1, categoriaInput.getId()).getResultList().get(0);
    }

	public List<String> findAllIndirizziDatoUnNumeroSerialeSpecifico(String input) throws Exception {
		Query q = entityManager.createNativeQuery(
				"select distinct o.indirizzospedizione from ordine o inner join articolo a on o.id=a.ordine_id inner join articolo_categoria ac on ac.articolo_id=a.id inner join categoria c on ac.categoria_id=c.id where a.numeroseriale like ?");
		q.setParameter(1, "%" + input + "%");
		return q.getResultList();
	}

}
