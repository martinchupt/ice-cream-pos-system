import junit.framework.Test;
import junit.framework.TestSuite;


public class IceCreamTestSuite extends TestSuite {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Ice Cream Tests");
		suite.addTestSuite(IceCreamFlavorTest.class);
		suite.addTestSuite(IceCreamDecoratorTest.class);
		return suite;
	}
	
}
