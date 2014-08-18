package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RuleconditionneighboursTest extends TestCase {
    private Ruleconditionneighbours ruleconditionneighboursTest;
    @Before
    public void setUp() throws Exception{
        ruleconditionneighboursTest = new Ruleconditionneighbours();
        ruleconditionneighboursTest.setRuleConditionNeighId(1);
        ruleconditionneighboursTest.setNeighbours("Neighbours");
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleconditionneighboursTest.getRuleConditionNeighId());
        assertEquals("Neighbours", ruleconditionneighboursTest.getNeighbours());
        assertEquals(-2006008779, ruleconditionneighboursTest.hashCode());
    }

}