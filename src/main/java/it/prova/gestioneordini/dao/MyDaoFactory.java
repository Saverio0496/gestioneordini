package it.prova.gestioneordini.dao;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.dao.ordine.OrdineDAOImpl;
import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.dao.articolo.ArticoloDAOImpl;
import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.dao.categoria.CategoriaDAOImpl;

public class MyDaoFactory {

	private static OrdineDAO ordineDaoInstance = null;
	private static ArticoloDAO articoloDaoInstance = null;
	private static CategoriaDAO categoriaDaoInstance = null;

	public static OrdineDAO getOrdineDAOInstance() {
		if (ordineDaoInstance == null)
			ordineDaoInstance = new OrdineDAOImpl();

		return ordineDaoInstance;
	}

	public static ArticoloDAO getArticoloDAOInstance() {
		if (articoloDaoInstance == null)
			articoloDaoInstance = new ArticoloDAOImpl();

		return articoloDaoInstance;
	}

	public static CategoriaDAO getCategoriaDAOInstance() {
		if (categoriaDaoInstance == null)
			categoriaDaoInstance = new CategoriaDAOImpl();

		return categoriaDaoInstance;
	}

}
