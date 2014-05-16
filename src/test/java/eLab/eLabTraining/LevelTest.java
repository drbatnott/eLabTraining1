package eLab.eLabTraining;

import junit.framework.TestCase;

public class LevelTest extends TestCase {

    public void testLevelWorks()
    {
    	Level t = new Level();
        assertNotNull(t);
    }
    
    public void testTimersVariables()
    {
    	Level t = new Level(2,40);
        assertEquals(2, t.getLevelNumber());
        assertEquals(40, t.getLevelTargetScore());
  
    }

}
