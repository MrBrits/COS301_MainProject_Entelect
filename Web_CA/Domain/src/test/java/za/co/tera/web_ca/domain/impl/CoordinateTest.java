package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest extends TestCase {
    private Coordinate coordinateTest;
    @Before
    public void setUp() throws Exception{
        coordinateTest = new Coordinate();
        coordinateTest.setCoordinateId(1);
        coordinateTest.setCoordinateX(0);
        coordinateTest.setCoordinateY(0);
        coordinateTest.setCoordinateZ(0);
        coordinateTest.setValue(123);
        coordinateTest.setWorldId(1);
    }

    @Test
    public void testCoordinate() throws Exception{
        assertEquals(1, coordinateTest.getCoordinateId());
        assertEquals(0, coordinateTest.getCoordinateX());
        assertEquals(0, coordinateTest.getCoordinateY());
        assertEquals(0, coordinateTest.getCoordinateZ());
        assertEquals(123, coordinateTest.getValue());
        assertEquals(1, coordinateTest.getWorldId());
        assertEquals(28632965, coordinateTest.hashCode());
    }

}