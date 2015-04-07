import icecream.IceCreamDecorator;
import icecream.IceCreamFlavor;
import icecream.IceCreamTransaction;
import junit.framework.TestCase;

import org.junit.Test;


public class IceCreamDecoratorTest extends TestCase {

	IceCreamTransaction iceCreamTransaction = new IceCreamTransaction();
	IceCreamFlavor flavor = new IceCreamFlavor();
	IceCreamDecorator decorator = new IceCreamDecorator();
	IceCreamDecorator decorator2 = new IceCreamDecorator();
	
	@Test
	public void testIceCreamDecorator() {
		flavor.setName("Mango");
		flavor.setDescription("MangoIceCream");
		flavor.setCost(20);
		iceCreamTransaction.setFlavor(flavor);
		decorator.setName("Jelly Bean");
		decorator.setDescription("");
		decorator.setCost(5);
		iceCreamTransaction.addDecoratorQuantity(decorator);
		String text = iceCreamTransaction.getSummary();
		System.out.println(text);
		assertEquals("MangoIceCream with Jelly Bean x 1 - Total Price: $25.0", text);
		
	}
	
	public void testIceCreamDecorator2() {
		flavor.setName("Banana");
		flavor.setDescription("BananaIceCream");
		flavor.setCost(20);
		iceCreamTransaction.setFlavor(flavor);
		
		decorator.setName("Jelly Bean");
		decorator.setDescription("JellyBean");
		decorator.setCost(5);
		iceCreamTransaction.addDecoratorQuantity(decorator);
		
		decorator2.setName("Coffee");
		decorator2.setDescription("");
		decorator2.setCost(7);
		iceCreamTransaction.addDecoratorQuantity(decorator2);
		iceCreamTransaction.addDecoratorQuantity(decorator2);
		
		String text = iceCreamTransaction.getSummary();
		System.out.println(text);
		assertEquals("BananaIceCream with Coffee x 2, Jelly Bean x 1 - Total Price: $39.0", text);
		
	}
	
	
}
