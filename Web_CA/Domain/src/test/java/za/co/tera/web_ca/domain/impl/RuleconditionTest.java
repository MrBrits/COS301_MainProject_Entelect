package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RuleconditionTest extends TestCase {
    private Rulecondition ruleconditionTest;
    @Before
    public void setUp() throws Exception{
        ruleconditionTest = new Rulecondition();
        ruleconditionTest.setRuleConditionId(1);
        ruleconditionTest.setNot(true);
        ruleconditionTest.setOperand("Operand");
        ruleconditionTest.setOperation("Operation");
        ruleconditionTest.setCompareValue(123);
        ruleconditionTest.setNeighboursId(1);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleconditionTest.getRuleConditionId());
        assertEquals(true, ruleconditionTest.isNot());
        assertEquals("Operand", ruleconditionTest.getOperand());
        assertEquals("Operation", ruleconditionTest.getOperation());
        assertEquals(123, ruleconditionTest.getCompareValue());
        assertEquals(1, ruleconditionTest.getNeighboursId());
        assertEquals(-708818232, ruleconditionTest.hashCode());
    }

}