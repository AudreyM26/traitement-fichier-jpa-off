package openfoodfacts.entites;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import openfoodfacts.*;

@Embeddable
public class ValeursNutrionnelles {

	@Column(name="ENERGIE_100G")
	private String energie100g;
	
	@Column(name="GRAISSE_100G")
	private String graisse100g;
	
	@Column(name="SUCRES_100G")
	private String sucres100g;
	
	@Column(name="FIBRES_100G")
	private String fibres100g;
	
	@Column(name="PROTEINES_100G")
	private String proteines100g;
	
	@Column(name="SEL_100G")
	private String sel100g;
	
	@Column(name="VITA_100G")
	private String vitA100g;
	
	@Column(name="VITD_100G")
	private String vitD100g;
	
	@Column(name="VITE_100G")
	private String vitE100g;
	
	@Column(name="VITK_100G")
	private String vitK100g;
	
	@Column(name="VITC_100G")
	private String vitC100g;
	
	@Column(name="VITB1_100G")
	private String vitB1100g;
	
	@Column(name="VITB2_100G")
	private String vitB2100g;
	
	@Column(name="VITPP_100G")
	private String vitPP100g;
	
	@Column(name="VITB6_100G")
	private String vitB6100g;
	
	@Column(name="VITB9_100G")
	private String vitB9100g;
	
	@Column(name="VITB12_100G")
	private String vitB12100g;
	
	@Column(name="CALCIUM_100G")
	private String calcium100g;
	
	@Column(name="MAGNESIUM_100G")
	private String magnesium100g;
	
	@Column(name="IRON_100G")
	private String iron100g;
	
	@Column(name="FER_100G")
	private String fer100g;
	
	@Column(name="BETACAROTENE_100G")
	private String betaCarotene100g;
	
	@Column(name="PRESENCE_HUILE_PALME_100G")
	private String presenceHuilePalme;
	
	
	public ValeursNutrionnelles() {
		super();
	}

	public ValeursNutrionnelles(Map<String, String> mapValNutri) {
		super();
		this.energie100g = mapValNutri.get("energie100g");
		this.graisse100g = mapValNutri.get("graisse100g");
		this.sucres100g = mapValNutri.get("sucres100g");
		this.fibres100g = mapValNutri.get("fibres100g");
		this.proteines100g = mapValNutri.get("proteines100g");
		this.sel100g = mapValNutri.get("sel100g");
		this.vitA100g = mapValNutri.get("vitA100g");
		this.vitD100g = mapValNutri.get("vitD100g");
		this.vitE100g = mapValNutri.get("vitE100g");
		this.vitK100g = mapValNutri.get("vitK100g");
		this.vitC100g = mapValNutri.get("vitC100g");
		this.vitB1100g = mapValNutri.get("vitB1100g");
		this.vitB2100g = mapValNutri.get("vitB2100g");
		this.vitPP100g = mapValNutri.get("vitPP100g");
		this.vitB6100g = mapValNutri.get("vitB6100g");
		this.vitB9100g = mapValNutri.get("vitB9100g");
		this.vitB12100g = mapValNutri.get("vitB12100g");
		this.calcium100g = mapValNutri.get("calcium100g");
		this.magnesium100g = mapValNutri.get("magnesium100g");
		this.iron100g = mapValNutri.get("iron100g");
		this.fer100g = mapValNutri.get("fer100g");
		this.betaCarotene100g = mapValNutri.get("betaCarotene100g");
		this.presenceHuilePalme = mapValNutri.get("presenceHuilePalme");
	}

	
}
