package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RuleTest extends TestCase {
    private Rule ruleTest;
    @Before
    public void setUp() throws Exception{
        ruleTest = new Rule();
        ruleTest.setRuleId(1);
        ruleTest.setRuleName("Rule Name");
        ruleTest.setRuleDesc("Rule Description");
        ruleTest.setPriority(1);
        ruleTest.setRuleConditionId(1);
        ruleTest.setRuleResultId(1);
        ruleTest.setOwnerId(1);
    }

    @Test
    public void testRule() throws Exception{
        assertEquals(1, ruleTest.getRuleId());
        assertEquals("Rule Name", ruleTest.getRuleName());
        assertEquals("Rule Description", ruleTest.getRuleDesc());
        assertEquals(1, ruleTest.getPriority());
        assertEquals(1, ruleTest.getRuleConditionId());
        assertEquals(1, ruleTest.getRuleResultId());
        assertEquals(1, ruleTest.getOwnerId());
        assertEquals(-194436982, ruleTest.hashCode());
    }

}