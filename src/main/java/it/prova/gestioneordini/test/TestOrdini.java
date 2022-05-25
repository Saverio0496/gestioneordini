package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
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

//			testAggiungiArticoloAOrdine(articoloServiceInstance, ordineServiceInstance);

//			testRimuoviArticoloDaOrdine(ordineServiceInstance, articoloServiceInstance);

			testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

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

//	private static void testAggiungiArticoloAOrdine(ArticoloService articoloServiceInstance,
//			OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testAggiungiArticoloAOrdine");
//		Articolo articoloPerTest = new Articolo("Forno a microonde", "67F59", 78,
//				new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2021"));
//		Ordine ordinePerTest3 = new Ordine("Laura", "Via Mosca 44",
//				new SimpleDateFormat("dd/MM/yyyy").parse("11/04/2022"));
//		articoloPerTest.setOrdine(ordinePerTest3);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest3);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest);
//		System.out.println("Fine testAggiungiArticoloAOrdine");
//	}

//	public static void testRimuoviArticoloDaOrdine(OrdineService ordineServiceInstance,
//			ArticoloService articoloServiceInstance) throws Exception {
//		System.out.println("Inizio testRimuoviArticoloDaOrdine");
//		Articolo articoloPerTest2 = new Articolo("Maglia", "6783H", 6,
//				new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2020"));
//		Ordine ordinePerTest4 = new Ordine("Lucia", "Via Castello 57",
//				new SimpleDateFormat("dd/MM/yyyy").parse("17/08/2021"));
//		articoloPerTest2.setOrdine(ordinePerTest4);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest4);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest2);
//		articoloServiceInstance.rimuovi(articoloPerTest2.getId());
//		System.out.println("Fine testRimuoviArticoloDaOrdine!");
//	}

	public static void testAggiungiArticoloACategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("Inizio testAggiungiArticoloACategoria");
		Ordine ordinePerTest4 = new Ordine("Saverio", "Via Mosca 52",
				new SimpleDateFormat("dd/MM/yyyy").parse("11/04/2022"));
		Articolo articoloPerTest3 = new Articolo("Barca", "89043S", 10000,
				new SimpleDateFormat("dd/MM/yyyy").parse("19/05/2021"));
		articoloPerTest3.setOrdine(ordinePerTest4);
		ordineServiceInstance.inserisciNuovo(ordinePerTest4);
		articoloServiceInstance.inserisciNuovo(articoloPerTest3);
		Categoria cartegoriaPerTest = new Categoria("Categoria marina", "708239F");
		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest);
		categoriaServiceInstance.aggiungiArticolo(cartegoriaPerTest, articoloPerTest3);
		System.out.println("Fine testAggiungiArticoloACategoria");
	}
}
