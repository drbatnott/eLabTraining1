package eLab.eLabTraining;
import junit.framework.TestCase;
public class TargetTest    extends TestCase {
    public void testTargetWorks()
    {
    	Target t = new Target();
        assertNotNull(t);
    }
    
    public void testTargetVariables()
    {
    	Target t = new Target(1);
        assertEquals(1, t.getPlayerID());
        assertEquals("none",t.getWinningState());
        assertEquals(0,t.getCurrentScore());
        
    }


}
