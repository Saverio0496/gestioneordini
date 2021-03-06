package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface ArticoloService {

	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Long idArticolo) throws Exception;

	public void aggiungiCategoria(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public Long cercaLaSommaTotalePrezziArticoli(Categoria categoriaInput) throws Exception;
	
	public Long cercaLaSommaPrezziArticoliMarioRossi() throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
