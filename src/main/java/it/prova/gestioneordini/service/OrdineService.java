package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineService {
	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Long idOrdine) throws Exception;
	
	public List<Ordine> cercaTuttiQuelliDataUnaCategoria(Categoria categoriaInput) throws Exception;
	
	public Ordine cercaQuelloPiuRecenteDataUnaCategoria(Categoria categoriaInput) throws Exception;
	
	public List<String> cercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico(String input) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);

}
