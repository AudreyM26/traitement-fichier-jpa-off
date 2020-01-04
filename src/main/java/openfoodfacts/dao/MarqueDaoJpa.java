package openfoodfacts.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import openfoodfacts.IntegrationOpenFoodFacts;
import openfoodfacts.entites.Marque;

public class MarqueDaoJpa implements MarqueDao {

	@Override
	public List<Marque> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marque selectExist(String nom) {
		// TODO Auto-generated method stub
		Marque marqueExist = null;
		
		TypedQuery<Marque> queryMarque = IntegrationOpenFoodFacts.em.createQuery("SELECT m FROM Marque m WHERE m.nom = :nom", Marque.class);
		queryMarque.setParameter("nom",nom);
		
		List<Marque> result = queryMarque.getResultList();
	
		if(!result.isEmpty()){
			marqueExist = result.get(0);
		}
		return marqueExist;
	}

	@Override
	public void insert(Marque marque) {
		// TODO Auto-generated method stub
		Marque marq = new Marque();
		marq.setNom(marque.getNom());

		IntegrationOpenFoodFacts.em.persist(marq);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
