package main_package;

public class Client {
	
	Tasse tasse;
	Cafe commandeCafe;
	String nom;
	float valeurFacture;
	
	public Client(String nom, Cafe commande, boolean aPasTasse) {
		this.nom = nom;
		this.commandeCafe = commande;
		if (aPasTasse)
			this.tasse = new Tasse();
	}
	
	public Client(String nom, Cafe commande, Tasse tasse) {
		this.nom = nom;
		this.commandeCafe = commande;
		this.tasse = tasse;
	}
	
	public Client() {
		this.nom = "Jean";
		this.tasse = new Tasse();
	}

}
