package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;

	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
	}

	public List<Ordine> listAll() throws Exception {
		return null;
	}

	public Ordine caricaSingoloElemento(Long id) throws Exception {
		return null;
	}

	public void aggiorna(Ordine ordineInstance) throws Exception {
	}

	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
	}

	public void rimuovi(Long idOrdine) throws Exception {
	}

}
