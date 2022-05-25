package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	
	public Categoria getEagerArticoli(Long id) throws Exception;
	
	public List<Categoria> findAllByOrdine(Ordine ordineInput) throws Exception;
	
	public List<String> findCodiciDiOrdiniEffettuatiAFebbraio() throws Exception;

}
