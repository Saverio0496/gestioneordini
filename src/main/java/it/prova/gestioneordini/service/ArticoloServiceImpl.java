package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;

	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	public List<Articolo> listAll() throws Exception {
		return null;
	}

	public Articolo caricaSingoloElemento(Long id) throws Exception {
		return null;
	}

	public void aggiorna(Articolo articoloInstance) throws Exception {
	}

	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
	}

	public void rimuovi(Long idArticolo) throws Exception {
	}

}
