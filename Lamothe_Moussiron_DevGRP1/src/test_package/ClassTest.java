package test_package;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;

import main_package.Cafe;
import main_package.Cafetiere;
import main_package.Tasse;
import main_package.TypeCafe;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testCreationTasse() {
		Tasse tasse = new Tasse();
		assertEquals(tasse.quantiteCafeMax, 100);
		assertNull(tasse.cafe);
	}

	@Test
	public void testBoireTropDeCafe() {
		Tasse tasse = new Tasse();
		tasse.cafe = new Cafe();
		tasse.boire(200);
		assertEquals(tasse.cafe.quantiteLiquideMl, 0);
	}
	
	@Test
	public void testRemplirTasse() {
		Tasse tasse = new Tasse();
		tasse.cafe = new Cafe();
		Cafetiere c = new Cafetiere();
		tasse.boire();
		c.remplirTasse(tasse);
		assertEquals(tasse.cafe.quantiteLiquideMl, 100);
	}
}
