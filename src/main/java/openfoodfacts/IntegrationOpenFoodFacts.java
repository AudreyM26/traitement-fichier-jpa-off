package openfoodfacts;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;

import openfoodfacts.services.ParseurProduit;

/***
 * creation des tables dans la base de donnéees open_food_facts
 * @author audrey
 *
 */
public class IntegrationOpenFoodFacts {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("openfoodfacts");
	public static EntityManager em = entityManagerFactory.createEntityManager();

	public static String colonneValeursNutri="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> lignes = null;

		String filePath = ClassLoader.getSystemClassLoader().getResource("open-food-facts.csv").getFile();
		System.out.println(filePath);
		
		//String test = "blé, lait, beurre,  lait, lactosérum de leee, soja, lait ";
		//test = test.replaceAll("(.)[\\s+,]+(\\s+)", "$1,");
		
		//System.out.println(test+"t");
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		try {
			File file = new File(filePath);
			lignes = FileUtils.readLines(file, "UTF-8");

			System.out.println(lignes.get(0));
			colonneValeursNutri = lignes.get(0);
			// recuperer nom colonne + numero de colonne pour remplir map
			// association nom / numero
			HashMap<String, Integer> mapIndexColumn = new HashMap<String, Integer>();

			String[] listeColonne = lignes.get(0).split("\\|");

			for (int i = 0; i < listeColonne.length; i++) {
				mapIndexColumn.put(listeColonne[i], i);
			}

			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);

			for (String ligne : lignes) {
				ParseurProduit.ajoutLigne(mapIndexColumn, ligne);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		transaction.commit();
		em.close();
	}

}
