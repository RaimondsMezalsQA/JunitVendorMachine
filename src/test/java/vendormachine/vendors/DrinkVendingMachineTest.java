package vendormachine.vendors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTest {

	DrinkVendingMachine venMachine = new DrinkVendingMachine();
	
	
	@Test
	public void selectDrinkTest() {
		Snack selection = venMachine.selectDrink(1);
		assertEquals(null, selection);
		
		DrinkVendingMachine drinkVen = new DrinkVendingMachine(10f, BRANDS.SoulWater);
		Snack selection2 = drinkVen.selectDrink(1);
		
		assertEquals(DefaultSnacks.snackList[1], selection2);
		
		Snack selection3 = venMachine.selectDrink(0);
		
		assertEquals(null, selection3);
	}
	
}
