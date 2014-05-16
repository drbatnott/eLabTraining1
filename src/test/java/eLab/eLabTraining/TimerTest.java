package eLab.eLabTraining;

import junit.framework.TestCase;

public class TimerTest  extends TestCase {
	
    public void testTimerWorks()
    {
    	Timer t = new Timer();
        assertNotNull(t);
    }
    
    public void testTimersVariables()
    {
     	Timer t = new Timer(60);
        assertEquals(60, t.getLevelTimer());
        assertEquals(0,t.getCurrentTimer());
        assertEquals(false,t.isFinished());
    }

}
