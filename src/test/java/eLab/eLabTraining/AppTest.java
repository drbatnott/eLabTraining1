package eLab.eLabTraining;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Not a rigourous Test :-)
     */
    public void testAppWorks()
    {
    	App newApp = new App();
        assertNotNull(newApp);
    }
    /**
     * Should be able to construct a Player object from a string
     */
    public void testPlayerConstructs()
    {
    	Player player = new Player("Fred");
    	assertNotNull(player);
    }
}
