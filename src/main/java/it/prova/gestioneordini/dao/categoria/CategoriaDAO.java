package it.prova.gestioneordini.dao.categoria;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	
	public Categoria getEagerArticoli(Long id) throws Exception;

}
