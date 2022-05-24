package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaDAO categoriaDAO;

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	public List<Categoria> listAll() throws Exception {
		return null;
	}

	public Categoria caricaSingoloElemento(Long id) throws Exception {
		return null;
	}

	public void aggiorna(Categoria categoriaInstance) throws Exception {
	}

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
	}

	public void rimuovi(Long idCategoria) throws Exception {
	}

}
