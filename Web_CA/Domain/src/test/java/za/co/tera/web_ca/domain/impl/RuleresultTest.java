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
        ruleresultTest.setOperand("Operand");
        ruleresultTest.setOperation("Operation");
        ruleresultTest.setResultValue(123);
        ruleresultTest.setNeighboursId(1);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleresultTest.getRuleResultId());
        assertEquals("Operand", ruleresultTest.getOperand());
        assertEquals("Operation", ruleresultTest.getOperation());
        assertEquals(123, ruleresultTest.getResultValue());
        assertEquals(1, ruleresultTest.getNeighboursId());
        assertEquals(-737447383, ruleresultTest.hashCode());
    }

}