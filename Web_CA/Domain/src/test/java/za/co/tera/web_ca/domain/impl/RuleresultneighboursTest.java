package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RuleresultneighboursTest extends TestCase {
    private Ruleresultneighbours ruleresultneighboursTest;
    @Before
    public void setUp() throws Exception{
        ruleresultneighboursTest = new Ruleresultneighbours();
        ruleresultneighboursTest.setRuleResultNeighId(1);
        ruleresultneighboursTest.setNeighbours("Neighbours");
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleresultneighboursTest.getRuleResultNeighId());
        assertEquals("Neighbours", ruleresultneighboursTest.getNeighbours());
        assertEquals(-2006008779, ruleresultneighboursTest.hashCode());
    }

}