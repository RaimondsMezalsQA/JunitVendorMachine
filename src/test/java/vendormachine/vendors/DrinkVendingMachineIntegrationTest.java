package vendormachine.vendors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;

public class DrinkVendingMachineIntegrationTest {
	
	
	@Mock
	private Wallet testWallet;
	private DrinkVendingMachine dvm = new DrinkVendingMachine();
	@InjectMocks
	private Person person = new Person("Brad");
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void giveCreditTest() {
		
		Mockito.when(testWallet.getAllCredit()).thenReturn(50f);
		Mockito.when(testWallet.getCredit(25.0f)).thenReturn(25.0f);
		
		dvm.giveCredit(person, 25.0f);
		
		assertEquals(25.0f, dvm.getAvailableCredit());
	
		Mockito.verify(testWallet, Mockito.times(1)).getAllCredit();
		Mockito.verify(testWallet, Mockito.times(1)).getCredit(25.0f);
	}
	
	@Test
	public void giveCreditFailTest() {
		
		Mockito.when(testWallet.getAllCredit()).thenReturn(10f);
		
		dvm.giveCredit(person, 25.0f);
		
		assertEquals(0f, dvm.getAvailableCredit());
	
		Mockito.verify(testWallet, Mockito.times(2)).getAllCredit();
	}
	

}
