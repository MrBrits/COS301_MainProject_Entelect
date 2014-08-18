package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class StateTest extends TestCase {
    private State stateTest;
    @Before
    public void setUp() throws Exception{
        stateTest = new State();
        stateTest.setStateId(1);
        stateTest.setStateName("State Name");
        stateTest.setStateDesc("State Description");
        stateTest.setStateHex("Hex Value");
        stateTest.setStateValue(123);
        stateTest.setOwnerId(1);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, stateTest.getStateId());
        assertEquals("State Name", stateTest.getStateName());
        assertEquals("State Description", stateTest.getStateDesc());
        assertEquals("Hex Value", stateTest.getStateHex());
        assertEquals(123, stateTest.getStateValue());
        assertEquals(1, stateTest.getOwnerId());
        assertEquals(-1829031396, stateTest.hashCode());
    }
}