package main_package;

public class Cafetiere {
	
	public Cafetiere() {
		
	}
	
	public static void remplirTasse(Tasse tasse) {
		tasse.cafe = new Cafe();
		tasse.cafe.quantiteLiquideMl = tasse.quantiteCafeMax;
	}
	
	public static void remplirTasse(Tasse tasse, TypeCafe typeCafe, double quantiteCafe) {
		if(tasse.cafe != null) {
			if(tasse.cafe.typeCafe != typeCafe) {
				tasse.cafe.typeCafe = TypeCafe.BATARD;
			} else {
				tasse.cafe.typeCafe = typeCafe;
			}
			tasse.cafe.quantiteLiquideMl += quantiteCafe;
		} else {
			tasse.cafe = new Cafe();
			tasse.cafe.typeCafe = typeCafe;
			tasse.cafe.quantiteLiquideMl = quantiteCafe;
		}
	}

}
