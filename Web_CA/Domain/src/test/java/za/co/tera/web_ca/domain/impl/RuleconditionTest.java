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
        ruleconditionTest.setCompareValueOne(123.0);
        ruleconditionTest.setCompareValueTwo(321.0);
        ruleconditionTest.setNeighboursId(1);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, ruleconditionTest.getRuleConditionId());
        assertEquals(true, ruleconditionTest.isNot());
        assertEquals("Operand", ruleconditionTest.getOperand());
        assertEquals("Operation", ruleconditionTest.getOperation());
        assertEquals(123.0, ruleconditionTest.getCompareValueOne());
        assertEquals(321.0, ruleconditionTest.getCompareValueTwo());
        assertEquals(1, ruleconditionTest.getNeighboursId());
        assertEquals(1376119919, ruleconditionTest.hashCode());
    }

}