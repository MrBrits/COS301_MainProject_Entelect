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
        ruleTest.setRuleConId(1);

        Integer one = new Integer(1);
        ruleTest.setRuleConAndid(one);
        ruleTest.setRuleConOrid(one);
        ruleTest.setRuleResId(one);
        ruleTest.setOwnerId(1);
    }

    @Test
    public void testRule() throws Exception{
        assertEquals(1, ruleTest.getRuleId());
        assertEquals("Rule Name", ruleTest.getRuleName());
        assertEquals("Rule Description", ruleTest.getRuleDesc());

        Integer one = new Integer(1);
        assertEquals(1, ruleTest.getRuleConId());
        assertEquals(one, ruleTest.getRuleConAndid());
        assertEquals(one, ruleTest.getRuleConOrid());
        assertEquals(one, ruleTest.getRuleResId());
        assertEquals(1, ruleTest.getOwnerId());
        assertEquals(-194436982, ruleTest.hashCode());
    }

}