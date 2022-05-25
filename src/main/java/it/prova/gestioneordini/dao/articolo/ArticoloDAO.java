package it.prova.gestioneordini.dao.articolo;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
	
	public Articolo getEagerCategorie(Long id) throws Exception;
	
	public Long findSumPrezziArticoliDataUnaCategoria(Categoria categoriaInput) throws Exception;
	

}
