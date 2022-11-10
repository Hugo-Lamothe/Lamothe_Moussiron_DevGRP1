package main_package;

public class Tasse {
	
	double quantiteCafeMax;
	Cafe cafe;
	
	public Tasse() {
		quantiteCafeMax = 100;
	}
	
	public Tasse(double quantiteCafeMax) {
		this.quantiteCafeMax = quantiteCafeMax;
	}
	
	public double boire(double quantiteBu) {
		double quantiteRestant = this.cafe.quantiteLiquideMl - quantiteBu;
		this.cafe.quantiteLiquideMl = quantiteRestant;
		return quantiteRestant;
	}
	
	public void boire() {
		this.cafe.quantiteLiquideMl = 0;
	}

}
