package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RuleresultTest extends TestCase {
    private Ruleresult ruleresultTest;
    @Before
    public void setUp() throws Exception{
        ruleresultTest = new Ruleresult();
        ruleresultTest.setRuleResultId(1);
        ruleresultTest.setOperation("Operation");
        ruleresultTest.setResultValue(123.0);

        Integer one = new Integer(1);
        ruleresultTest.setNeighboursId(one);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleresultTest.getRuleResultId());
        assertEquals("Operation", ruleresultTest.getOperation());
        assertEquals(123.0, ruleresultTest.getResultValue());

        Integer one = new Integer(1);
        //assertEquals(one, ruleresultTest.getNeighboursId());
        assertEquals(-737447383, ruleresultTest.hashCode());
    }

}