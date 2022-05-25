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

//			testCercaLaSommaTotalePrezziArticoli(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

			testCercaQuelloPiuRecenteDataUnaCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testCercaTutteQuelleConOrdiniEffettuatiAFebbraio(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testCercaLaSommaPrezziArticoliMarioRossi(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testCercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico(articoloServiceInstance, categoriaServiceInstance,
//					ordineServiceInstance);
			
			
			

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

//	public static void testCercaLaSommaTotalePrezziArticoli(ArticoloService articoloServiceInstance,
//			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaLaSommaTotalePrezziArticoli");
//		Ordine ordinePerTest7 = new Ordine("Luigi", "Via Manza 10",
//				new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2022"));
//		Articolo articoloPerTest6 = new Articolo("Batterie", "9065E", 10,
//				new SimpleDateFormat("dd/MM/yyyy").parse("14/09/2021"));
//		articoloPerTest6.setOrdine(ordinePerTest7);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest7);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest6);
//		Categoria cartegoriaPerTest4 = new Categoria("Utensili", "012132P");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest4);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest4, articoloPerTest6);
//		System.out.println(articoloServiceInstance.cercaLaSommaTotalePrezziArticoli(cartegoriaPerTest4));
//		System.out.println("Fine testCercaLaSommaTotalePrezziArticoli!");
//	}

	public static void testCercaQuelloPiuRecenteDataUnaCategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("Inizio testCercaQuelloPiuRecenteDataUnaCategoria");
		Ordine ordinePerTest8 = new Ordine("Claudio", "Via Manzoni 7",
				new SimpleDateFormat("dd/MM/yyyy").parse("23/05/2020"));
		Articolo articoloPerTest7 = new Articolo("Volante", "1278T", 200,
				new SimpleDateFormat("dd/MM/yyyy").parse("16/08/2022"));
		Categoria cartegoriaPerTest5 = new Categoria("Videogiochi", "923782R");
		ordineServiceInstance.inserisciNuovo(ordinePerTest8);
		articoloPerTest7.setOrdine(ordinePerTest8);
		articoloServiceInstance.inserisciNuovo(articoloPerTest7);
		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest5);
		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest5, articoloPerTest7);
		System.out.println(ordineServiceInstance.cercaQuelloPiuRecenteDataUnaCategoria(cartegoriaPerTest5));
		System.out.println("Fine testCercaQuelloPiuRecenteDataUnaCategoria!");
	}

//	public static void testCercaTutteQuelleConOrdiniEffettuatiAFebbraio(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaTutteQuelleConOrdiniEffettuatiAFebbraio");
//		Ordine ordinePerTest9 = new Ordine("Luisa", "Via Mezzo 10",
//				new SimpleDateFormat("dd/MM/yyyy").parse("25/02/2022"));
//		Articolo articoloPerTest8 = new Articolo("Borraccia", "9000E", 3,
//				new SimpleDateFormat("dd/MM/yyyy").parse("14/09/2022"));
//		articoloPerTest8.setOrdine(ordinePerTest9);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest9);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest8);
//		Categoria cartegoriaPerTest6 = new Categoria("Utensili", "012135L");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest6);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest6, articoloPerTest8);
//		List<String> elencoCategorieTrovate = categoriaServiceInstance.cercaTutteQuelleConOrdiniEffettuatiAFebbraio();
//		for(String stringItem : elencoCategorieTrovate)
//			System.out.println(stringItem);
//		System.out.println("Fine testCercaTutteQuelleConOrdiniEffettuatiAFebbraio!");
//		
//	}

//	public static void testCercaLaSommaPrezziArticoliMarioRossi(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaLaSommaPrezziArticoliMarioRossi");
//		Ordine ordinePerTest10 = new Ordine("Mario Rossi", "Via Mezzuomo 2",
//				new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2019"));
//		Articolo articoloPerTest9 = new Articolo("Dizionario", "9322W", 25,
//				new SimpleDateFormat("dd/MM/yyyy").parse("04/05/2021"));
//		Articolo articoloPerTest10 = new Articolo("Rubrica Telefonica", "1213Y", 10,
//				new SimpleDateFormat("dd/MM/yyyy").parse("14/07/2021"));
//		articoloPerTest9.setOrdine(ordinePerTest10);
//		articoloPerTest10.setOrdine(ordinePerTest10);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest10);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest9);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest10);
//		Categoria cartegoriaPerTest7 = new Categoria("Libri", "012914G");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest7);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest7, articoloPerTest9);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest7, articoloPerTest10);
//		System.out.println(articoloServiceInstance.cercaLaSommaPrezziArticoliMarioRossi());
//		System.out.println("Fine testCercaLaSommaPrezziArticoliMarioRossi!");
//	}

//	public static void testCercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico(ArticoloService articoloServiceInstance,
//			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {
//		System.out.println("Inizio testCercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico");
//		Ordine ordinePerTest11 = new Ordine("Gianluca", "Via Mosca 2",
//				new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2022"));
//		Articolo articoloPerTest11 = new Articolo("Figurina", "8945H", 2,
//				new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"));
//		articoloPerTest11.setOrdine(ordinePerTest11);
//		ordineServiceInstance.inserisciNuovo(ordinePerTest11);
//		articoloServiceInstance.inserisciNuovo(articoloPerTest11);
//		Categoria cartegoriaPerTest8 = new Categoria("Collezionismo", "311312D");
//		categoriaServiceInstance.inserisciNuovo(cartegoriaPerTest8);
//		articoloServiceInstance.aggiungiCategoria(cartegoriaPerTest8, articoloPerTest11);
//		String inputPerControllare = "45H";
//		List<String> elencoStringheTrovate = ordineServiceInstance
//				.cercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico(inputPerControllare);
//		for (String stringItem : elencoStringheTrovate)
//			System.out.println(stringItem);
//		System.out.println("Fine testCercaTuttiGliIndirizziDatoUnNumeroSerialeSpecifico");
//	}

}