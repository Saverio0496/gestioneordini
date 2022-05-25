package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;
import java.util.List;

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

//			testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testAggiungiCategoriaAdArticolo(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testRimozioneArticolo(articoloServiceInstance);

//			testRimozioneCategoria(categoriaServiceInstance);

//			testRimozioneOrdine(ordineServiceInstance);

//			testCercaTuttiGliOrdiniDataUnaCategoria(ordineServiceInstance, categoriaServiceInstance);

//			testCercaTutteQuelleDatoUnOrdine(ordineServiceInstance, categoriaServiceInstance, articoloServiceInstance);
			
			testCercaLaSommaTotalePrezziArticoli(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

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

//	public static void testAggiungiArticoloACategoria(ArticoloService articoloServiceInstance,
//			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testAggiungiArticoloACategoria");
//		Ordine ordinePerTest4 = new Ordine("Saverio", "Via Mosca 52",
//				new SimpleDateFormat("dd/MM/yyyy").parse("11/04/2022"));
//		Articolo articoloPerTest3 = new Articolo("Barca", "89043S", 10000,
//				new SimpleDateFormat("dd/MM/yyyy").parse("19/05/2021"));
//		articoloPerTest3.setOrdine(ordinePerTest4);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest4);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest3);
//		Categoria cartegoriaPerTest = new Categoria("Categoria marina", "708239F");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest);
//		categoriaServiceInstance.aggiungiArticolo(cartegoriaPerTest, articoloPerTest3);
//		System.out.println("Fine testAggiungiArticoloACategoria");
//	}

//	public static void testAggiungiCategoriaAdArticolo(ArticoloService articoloServiceInstance,
//			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testAggiungiCategoriaAdArticolo");
//		Ordine ordinePerTest5 = new Ordine("Alessio", "Via Mosca 50",
//				new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2020"));
//		Articolo articoloPerTest4 = new Articolo("Cioccolata", "80563A", 2,
//				new SimpleDateFormat("dd/MM/yyyy").parse("11/09/2019"));
//		articoloPerTest4.setOrdine(ordinePerTest5);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest5);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest4);
//		Categoria cartegoriaPerTest2 = new Categoria("Dolci", "091032R");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest2);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest2, articoloPerTest4);
//		System.out.println("Fine testAggiungiCategoriaAdArticolo");
//	}

//	public static void testRimozioneArticolo(ArticoloService articoloServiceInstance) throws Exception {
//		System.out.println("Inizio testRimozioneArticolo");
//		List<Articolo> elencoArticoliPresenti = articoloServiceInstance.listAll();
//		Articolo articoloDaCancellare = elencoArticoliPresenti.get(0);
//		articoloServiceInstance.rimuovi(articoloDaCancellare.getId());
//		System.out.println("Fine testRimozioneArticolo!");
//	}

//	public static void testRimozioneCategoria(CategoriaService categoriaServiceInstance) throws Exception {
//		System.out.println("Inizio testRimozioneCategoria");
//		List<Categoria> elencoCategoriePresenti = categoriaServiceInstance.listAll();
//		Categoria categoriaDaCancellare = elencoCategoriePresenti.get(0);
//		categoriaServiceInstance.rimuovi(categoriaDaCancellare.getId());
//		System.out.println("Fine testRimozioneCategoria!");
//	}

//	public static void testCercaTuttiGliOrdiniDataUnaCategoria(OrdineService ordineServiceInstance,
//			CategoriaService categoriaServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaTuttiGliOrdiniDataUnaCategoria");
//		List<Categoria> elencoCategoriePresenti = categoriaServiceInstance.listAll();
//		Categoria categoriaPerRicerca = elencoCategoriePresenti.get(0);
//		System.out.println(ordineServiceInstance.cercaTuttiQuelliDataUnaCategoria(categoriaPerRicerca));
//		System.out.println("Fine testCercaTuttiGliOrdiniDataUnaCategoria!");
//	}

//	public static void testCercaTutteQuelleDatoUnOrdine(OrdineService ordineServiceInstance,
//			CategoriaService categoriaServiceInstance, ArticoloService articoloServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaTutteQuelleDatoUnOrdine");
//		Ordine ordinePerTest6 = new Ordine("Luca", "Via Manzoni 10",
//				new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2021"));
//		Articolo articoloPerTest5 = new Articolo("Camicia", "9065E", 2,
//				new SimpleDateFormat("dd/MM/yyyy").parse("14/09/2022"));
//		articoloPerTest5.setOrdine(ordinePerTest6);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest6);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest5);
//		Categoria cartegoriaPerTest3 = new Categoria("Vestiti", "012132P");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest3);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest3, articoloPerTest5);
//		System.out.println(categoriaServiceInstance.cercaTutteQuelleDatoUnOrdine(ordinePerTest6));
//		System.out.println("Fine testCercaTutteQuelleDatoUnOrdine!");
//	}

	public static void testCercaLaSommaTotalePrezziArticoli(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("Inizio testCercaLaSommaTotalePrezziArticoli");
		Ordine ordinePerTest7 = new Ordine("Luigi", "Via Manza 10",
				new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2022"));
		Articolo articoloPerTest6 = new Articolo("Batterie", "9065E", 10,
				new SimpleDateFormat("dd/MM/yyyy").parse("14/09/2021"));
		articoloPerTest6.setOrdine(ordinePerTest7);
		ordineServiceInstance.inserisciNuovo(ordinePerTest7);
		articoloServiceInstance.inserisciNuovo(articoloPerTest6);
		Categoria cartegoriaPerTest4 = new Categoria("Utensili", "012132P");
		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest4);
		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest4, articoloPerTest6);
		System.out.println(articoloServiceInstance.cercaLaSommaTotalePrezziArticoli(cartegoriaPerTest4));
		System.out.println("Fine testCercaLaSommaTotalePrezziArticoli!");
	}

}