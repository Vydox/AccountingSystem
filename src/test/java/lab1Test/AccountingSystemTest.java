package lab1Test;

import lab1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountingSystemTest {

    private AccountingSystem AS;

    @BeforeEach
    public void setUp() {
        AS = new AccountingSystem();

        AS.createBuilding(2, 2);
        AS.setFlat(0, 0, 10, 5);
        AS.setFlat(0, 1, 20, 5);


        AS.createBuilding(3, 1);
        AS.setFlat(1, 0, 1, 1);
        AS.setFlat(1, 1, 2, 2);
        AS.setFlat(1, 2, 3, 3);

    }


    @Test
    public void createBuildingTest() {
        AS.createBuilding();
        Assertions.assertEquals(3, AS.getBuildingsAmount());
    }

    @Test
    public void deleteBuildingTest() {
        AS.deleteBuilding(1);
        Assertions.assertEquals(1, AS.getBuildingsAmount());
    }

    @Test
    public void compareBuildingsTotalFLatsTest() {
        Assertions.assertEquals(-1, AS.compareBuildingsTotalFLats(1, 2));
    }

    @Test
    public void compareBuildingsTotalAreaTest() {
        Assertions.assertEquals(1, AS.compareBuildingsTotalArea(1, 2));
    }

    @Test
    public void compareBuildingsTotalResidentsTest() {
        Assertions.assertEquals(1, AS.compareBuildingsTotalResidents(1, 2));
    }

    @Test
    public void compareBuildingsTotalFloorsTest() {
        Assertions.assertEquals(-1, AS.compareBuildingsTotalFloors(1, 2));
    }

    @Test
    public void compareBuildingsFullTest() {
        int[] compExp = {-1, 1, 1, -1};
        int[] compAct = AS.compareBuildingsFull(1, 2);
        Assertions.assertArrayEquals(compExp, compAct);
    }


    @Test
    public void compareFlatsTotalAreaTest() {
        Assertions.assertEquals(1, AS.compareFlatsTotalArea(1, 1, 2, 1));
    }

    @Test
    public void compareFlatsTotalResidentsTest() {
        Assertions.assertEquals(1, AS.compareFlatsTotalResidents(1, 1, 2, 1));
    }

    @Test
    public void compareFlatsFullTest() {
        int[] compExp = {1, 1};
        int[] compAct = AS.compareFlatsFull(1, 1, 2, 1);
        Assertions.assertArrayEquals(compExp, compAct);
    }
}