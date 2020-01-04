package openfoodfacts.dao;

import java.util.List;

import javax.persistence.*;

import openfoodfacts.IntegrationOpenFoodFacts;
import openfoodfacts.entites.Categorie;

public class CategorieDaoJpa implements CategorieDao {

	@Override
	public List<Categorie> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie selectExist(String nom) {
		// TODO Auto-generated method stub
		Categorie categExist = null;
		
		TypedQuery<Categorie> queryCateg = IntegrationOpenFoodFacts.em.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class);
		queryCateg.setParameter("nom",nom);
		
		List<Categorie> result = queryCateg.getResultList();
	
		if(!result.isEmpty()){
			categExist = result.get(0);
		}
		return categExist;
	}

	
	@Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub
		
		Categorie categ = new Categorie();
		categ.setNom(categorie.getNom());
		
		
		IntegrationOpenFoodFacts.em.persist(categ);
		
		
	}
	
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
