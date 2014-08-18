package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class WorldrulesTest extends TestCase {
    private Worldrules worldrulesTest;
    @Before
    public void setUp() throws Exception{
        worldrulesTest = new Worldrules();
        worldrulesTest.setWorldRulesId(1);
        worldrulesTest.setWorldId(1);
        worldrulesTest.setRuleId(1);
    }

    @Test
    public void testState() throws Exception{
        assertEquals(1, worldrulesTest.getWorldRulesId());
        assertEquals(1, worldrulesTest.getWorldId());
        assertEquals(1, worldrulesTest.getRuleId());
        assertEquals(993, worldrulesTest.hashCode());
    }

}