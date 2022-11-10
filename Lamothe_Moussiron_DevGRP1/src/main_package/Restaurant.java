package main_package;

import java.util.ArrayList;

public class Restaurant {

	Cafetiere cafetiere;
	float profit;
	ArrayList<Client> listeClientServi;
	String nom;
	
	public Restaurant() {
		nom = "Le Restaurant";
		this.cafetiere = new Cafetiere();
		listeClientServi = new ArrayList<>();	
	}
	
	public Restaurant(String nom) {
		this.nom = nom;
		cafetiere = new Cafetiere();
		listeClientServi = new ArrayList<>();	
	}
	
	public static boolean ejecter(Client client) {
		boolean sortir = false;
		
		if(client.commandeCafe == null || client.commandeCafe.typeCafe == TypeCafe.BATARD) {
			System.out.println("mettre le client dehors !");
			sortir = true;
		} else if(client.commandeCafe.typeCafe == TypeCafe.BATARD) {
			System.out.println("mettre le client dehors !");
			sortir = true;
		}
		
		return sortir;
	}
	
	public float servir(Client client) {
		if(client.commandeCafe != null) {
			if(client.tasse == null) {
				if(client.commandeCafe.quantiteLiquideMl > 100) {
					client.valeurFacture += 3;
					client.tasse = new Tasse(500);
				} else {
					client.valeurFacture += 2;
					client.tasse = new Tasse();
				}
			}
			
			if(client.commandeCafe.quantiteLiquideMl > client.tasse.quantiteCafeMax) {
				System.out.println("Le café va déborder !");
				Cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.tasse.quantiteCafeMax);
			} else if(client.tasse.cafe != null && client.tasse.cafe.typeCafe != client.commandeCafe.typeCafe) {
				client.tasse.cafe.typeCafe = TypeCafe.BATARD;
				Cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.commandeCafe.quantiteLiquideMl);
			} else {
				Cafetiere.remplirTasse(client.tasse, client.commandeCafe.typeCafe, client.commandeCafe.quantiteLiquideMl);
			}
			
			client.valeurFacture += client.commandeCafe.typeCafe.coutParMl * client.commandeCafe.quantiteLiquideMl;
		}
		if(!ejecter(client)) {
			this.profit += client.valeurFacture;
			return client.valeurFacture;
		}
		client.valeurFacture = 0;
		this.profit = client.valeurFacture;
		return client.valeurFacture;
	}
	
}
