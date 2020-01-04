package openfoodfacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import javax.persistence.*;

import openfoodfacts.entites.*;
import openfoodfacts.*;

public class ProduitDaoJpa implements ProduitDao {


	List<Object> valeurAttribut = new ArrayList<Object>();
	
	@Override
	public List<Produit> extraire() {
		// TODO Auto-generated method stub
		List<Produit> produits = new ArrayList<Produit>();
	
		Query requete = IntegrationOpenFoodFacts.em.createQuery("select * from article a inner join fournisseur f on a.ID_FOURNISSEUR = f.ID order by a.ID");

		produits =  requete.getResultList();
		
		return produits;
	}


	@Override
	public void insert(Produit produit) {

		Produit p = new Produit();
		p.setNom(produit.getNom());
		p.setScoreNutrionnel(produit.getScoreNutrionnel());
		p.setMarque(produit.getMarque());
		p.setCategorie(produit.getCategorie());
		p.setValeursNutrionnelles(produit.getValeursNutrionnelles());
		
	
		if(!produit.getAdditifs().isEmpty()){
			p.setAdditifs(produit.getAdditifs());
		}
		if(!produit.getAllergenes().isEmpty()){
			p.setAllergenes(produit.getAllergenes());
		}
		if(!produit.getIngredients().isEmpty()){
			p.setIngredients(produit.getIngredients());
		}
		IntegrationOpenFoodFacts.em.persist(p);

	}

	/*@Override
	public int update(int nouvelleValeur,EntityManager em) {
		// TODO Auto-generated method stub
		//String requete = "update article set prix= prix-(prix*"+nouvelleValeur+"/100) where designation like '%mate%'";
		Query requete = em.createQuery("update article set prix= prix-(prix*?/100) where designation like '%mate%'");
		
		requete.executeUpdate();
		//System.out.println(requete);
		return 0;
	}*/

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		Boolean suppr = false;
		String requete = "delete from article where designation like '%Peinture%'";
		
		int nb = 0;
		
		if(nb > 0){
			suppr= true;
		}
		return suppr;
	}

}
