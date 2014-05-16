package eLab.eLabTraining;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	/**
     * Should be able to construct a Player object from a string
     */
	
    public void testPlayerConstructs()
    {
    	Player player = new Player("Fred");
    	assertNotNull(player);
    }

}
