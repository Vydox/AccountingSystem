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

        AS.createBuilding();
        AS.Buildings.get(0).setTotalFlats(10);
        AS.Buildings.get(0).setTotalArea(100.0);
        AS.Buildings.get(0).setTotalResidents(20);
        AS.Buildings.get(0).setTotalFloors(5);

        AS.createBuilding();
        AS.Buildings.get(1).setTotalFlats(20);
        AS.Buildings.get(1).setTotalArea(50.0);
        AS.Buildings.get(1).setTotalResidents(20);
        AS.Buildings.get(1).setTotalFloors(6);

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
        Assertions.assertEquals(0, AS.compareBuildingsTotalResidents(1, 2));
    }

    @Test
    public void compareBuildingsTotalFloorsTest() {
        Assertions.assertEquals(-1, AS.compareBuildingsTotalFloors(1, 2));
    }

    @Test
    public void compareBuildingsFullTest() {
        int[] compExp = {-1, 1, 0, -1};
        int[] compAct = AS.compareBuildingsFull(1, 2);
        Assertions.assertArrayEquals(compExp, compAct);
    }

}