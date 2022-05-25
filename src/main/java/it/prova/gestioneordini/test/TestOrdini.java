package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Articolo;
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
//			testInserimentoOrdine(ordineServiceInstance);

//			testAggiornaOrdine(ordineServiceInstance);

			testAggiungiArticoloAOrdine(articoloServiceInstance, ordineServiceInstance);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

//	private static void testInserimentoOrdine(OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testInserimentoOrdine");
//		Ordine ordinePerTest = new Ordine("Cristian", "Via Cerce 14",
//				new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2019"));
//		ordineServiceInstance.inserisciNuovo(ordinePerTest);
//		if (ordinePerTest.getId() == null)
//			throw new RuntimeException("testInserimentoOrdine fallito!");
//		System.out.println("Fine testInserimentoOrdine!");
//	}

//	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testAggiornaOrdine");
//		Ordine ordinePerTest2 = new Ordine("Saverio", "Via Inghilterra 44",
//				new SimpleDateFormat("dd/MM/yyyy").parse("12/03/2022"));
//		ordineServiceInstance.inserisciNuovo(ordinePerTest2);
//		if (ordinePerTest2.getId() == null)
//			throw new RuntimeException("testAggiornaOrdine fallito!");
//		System.out.println("Stampa prima della modifica:");
//		System.out.println(ordinePerTest2);
//		ordinePerTest2.setNomeDestinatario("Matteo");
//		ordineServiceInstance.aggiorna(ordinePerTest2);
//		System.out.println("Stampa dopo la modifica:");
//		System.out.println(ordinePerTest2);
//		System.out.println("Fine testAggiornaOrdine!");
//	}

	private static void testAggiungiArticoloAOrdine(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println("Inizio testAggiungiArticoloAOrdine");
		Articolo articoloPerTest = new Articolo("Forno a microonde", "67F59", 78,
				new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2021"));
		Ordine ordinePerTest3 = new Ordine("Laura", "Via Mosca 44",
				new SimpleDateFormat("dd/MM/yyyy").parse("11/04/2022"));
		articoloPerTest.setOrdine(ordinePerTest3);
		ordineServiceInstance.inserisciNuovo(ordinePerTest3);
		articoloServiceInstance.inserisciNuovo(articoloPerTest);
		System.out.println("Fine testAggiungiArticoloAOrdine");
	}
}
