package lab1Test;

import lab1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildingTest {

    private Building B1;

    @BeforeEach
    public void setUp() {
        B1 = new Building();
        B1.setTotalArea(100);
        B1.setTotalFloors(5);
        B1.setTotalFlats(5);
        B1.setTotalResidents(20);
    }

    @Test
    public void getTotalAreaTest() {
        Assertions.assertEquals(100, B1.getTotalArea());
    }

    @Test
    public void getTotalFloorsTest() {
        Assertions.assertEquals(5, B1.getTotalFloors());
    }

    @Test
    public void getTotalFlatsTest() {
        Assertions.assertEquals(5, B1.getTotalFlats());
    }

    @Test
    public void getTotalResidentsTest() {
        Assertions.assertEquals(20, B1.getTotalResidents());
    }

    @Test
    public void setTotalAreaTest() {
        B1.setTotalArea(50);
        Assertions.assertEquals(50, B1.getTotalArea());
    }

    @Test
    public void setTotalFloorsTest() {
        B1.setTotalFloors(10);
        Assertions.assertEquals(10, B1.getTotalFloors());
    }

    @Test
    public void setTotalFlatsTest() {
        B1.setTotalFlats(10);
        Assertions.assertEquals(10, B1.getTotalFlats());
    }

    @Test
    public void setTotalResidentsTest() {
        B1.setTotalResidents(30);
        Assertions.assertEquals(30, B1.getTotalResidents());
    }



}