package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Ordine;
import it.prova.gestioneordini.service.ArticoloService;
import it.prova.gestioneordini.service.CategoriaService;
import it.prova.gestioneordini.service.MyServiceFactory;
import it.prova.gestioneordini.service.OrdineService;

public class TestOrdini {

	public static void main(String[] args) {
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
			System.out
					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"**************************** inizio batteria di test ********************************************");
			testInserimentoOrdine(ordineServiceInstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

	private static void testInserimentoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("Inizio testInserimentoOrdine");
		Ordine ordinePerTest = new Ordine("Cristian", "Via Cerce 14",
				new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2019"));
		ordineServiceInstance.inserisciNuovo(ordinePerTest);
		if (ordinePerTest.getId() == null)
			throw new RuntimeException("testInserimentoOrdine fallito!");
		System.out.println("Fine testInserimentoOrdine!");
	}
}
