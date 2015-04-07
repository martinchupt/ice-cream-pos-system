import icecream.IceCreamFlavor;
import icecream.IceCreamTransaction;
import junit.framework.TestCase;


public class IceCreamFlavorTest extends TestCase {

	IceCreamTransaction iceCreamTransaction = new IceCreamTransaction();
	IceCreamFlavor flavor = new IceCreamFlavor();
	
	public void testIceCreamFlavor() {
		flavor.setName("Mango");
		flavor.setDescription("MangoIceCream");
		flavor.setCost(20);
		iceCreamTransaction.setFlavor(flavor);
		String text = iceCreamTransaction.getSummary();
		System.out.println(text);
		assertEquals("MangoIceCream - Total Price: $20.0", text);
	}
	


}
