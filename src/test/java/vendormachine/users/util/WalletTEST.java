package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTEST {

	private static Wallet testWallet = new Wallet();
	
	@AfterEach
	public void afterTest() {
    	testWallet.setCredit(0);
    	testWallet.setBrand("Generic");
	}
	@BeforeEach
	public void beforeTest() {
    	testWallet.setCredit(0);
    	testWallet.setBrand("Generic");
	}
	
    @Test
    public void addCreditTest(){
    	testWallet.addCredit(10f);

    	assertEquals(10f, testWallet.getAllCredit());
    }
    
    @Test
    public void getCreditTest() {
    	float biggerReturn = testWallet.getCredit(10f);
    	testWallet.setCredit(0.5f);
    	float smallerReturn = testWallet.getCredit(0.1f);
    	
    	assertEquals(0f, biggerReturn);
    	assertEquals(0.1f, smallerReturn);
    }
    
    @Test
    public void getBrandTest() {
    	assertEquals("Generic", testWallet.getBrand(null));
    }
    
    @Test
    public void setBrandTest() {
    	testWallet.setBrand("Updated");
    	assertEquals("Updated", testWallet.getBrand(null));
    }
    
    @Test
    public void constructorTest() {
    	Wallet wal1 = new Wallet(10f);
		assertTrue(wal1 instanceof Wallet);
		
		Wallet wal2 = new Wallet("Jackson", 10f);
		assertTrue(wal2 instanceof Wallet);
    }
    
}
