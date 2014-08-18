package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class WorldTest extends TestCase {
    private World worldTest;
    @Before
    public void setUp() throws Exception{
        worldTest = new World();
        worldTest.setWorldId(1);
        worldTest.setWorldName("World Name");
        worldTest.setWorldDesc("World Description");
        worldTest.setWorldDimension(1);
        worldTest.setWorldWidth(1);
        worldTest.setWorldHeight(1);
        worldTest.setWorldDepth(1);
        worldTest.setOwnerId(1);
    }

    @Test
    public void testWorld() throws Exception{
        assertEquals(1, worldTest.getWorldId());
        assertEquals("World Name", worldTest.getWorldName());
        assertEquals("World Description", worldTest.getWorldDesc());
        assertEquals(1, worldTest.getWorldDimension());
        assertEquals(1, worldTest.getWorldWidth());
        assertEquals(1, worldTest.getWorldHeight());
        assertEquals(1, worldTest.getWorldDepth());
        assertEquals(1, worldTest.getOwnerId());
        assertEquals(1798059275, worldTest.hashCode());
    }

}