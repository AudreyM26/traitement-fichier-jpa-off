package openfoodfacts.dao;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import openfoodfacts.IntegrationOpenFoodFacts;
import openfoodfacts.entites.Additif;
import openfoodfacts.entites.Allergene;
import openfoodfacts.entites.Ingredient;

public class NutrimentDaoJpa implements NutrimentDao {

	@Override
	public List<Object> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Object[] selectExist(String nom, String table) {
		// TODO Auto-generated method stub
		Object object[] = null;
	
		Query query = IntegrationOpenFoodFacts.em.createQuery("SELECT o.id,o.nom FROM " + table + " o WHERE o.nom = :nom");
		query.setParameter("nom", nom);

		List<Object[]> result = query.getResultList();
		
		if(!result.isEmpty()){
			
			for(Object[] line : result){
				object = line;
			}
			
		}
		
		return object;
	}
	
	@Override
	public void insertAdditifs(Additif additif) {
		// TODO Auto-generated method stub

		Additif nutriment = new Additif();
		nutriment.setNom(additif.getNom());
		
		IntegrationOpenFoodFacts.em.persist(nutriment);
	}

	@Override
	public void insertAllergenes(Allergene allergene) {
		// TODO Auto-generated method stub
		Allergene nutriment = new Allergene();
		nutriment.setNom(allergene.getNom());
		
		IntegrationOpenFoodFacts.em.persist(nutriment);
	}

	@Override
	public void insertIngredients(Ingredient ingredient) {
		// TODO Auto-generated method stub
		Ingredient nutriment = new Ingredient();
		nutriment.setNom(ingredient.getNom());
		
		IntegrationOpenFoodFacts.em.persist(nutriment);
	}
	
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}



}
