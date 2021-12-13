package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class AccountingSystem {

    public List<Building> Buildings = new ArrayList<>();

    public void createBuilding() {
        Buildings.add(new Building());
    }

    public void createBuilding(int fl, int fpf) {
        Buildings.add(new Building(fl, fpf));
    }

    public void setFlat(int building, int flat, double area, int residents) {
        Buildings.get(building).flatsTotal.get(flat).setFlatArea(area);
        Buildings.get(building).flatsTotal.get(flat).setFlatResidents(residents);
    }

    public void deleteBuilding(int num) {
        Buildings.remove(num - 1);
    }

    public int getBuildingsAmount() {
        return Buildings.size();
    }

    public void getFullBuildingInfo(int num) {
        if (num > 0 && num <= Buildings.size()) {
            System.out.println("Building " + (num+1));
            System.out.println(Buildings.get(num));
        } else System.out.println("Incorrect input: there is no building with such number");
    }

    public void getFullSystemInfo() {
        System.out.println("There are " + Buildings.size() + " buildings in your system\n");
        if (Buildings.size() != 0) {
            for (int i = 1; i <= Buildings.size(); i++) {
                getFullBuildingInfo(i);
                System.out.println("\n");
            }
        }
    }



    public int compareBuildingsTotalFLats(int num1, int num2) {
        return(Integer.compare(Buildings.get(num1 - 1).getTotalFlats(), Buildings.get(num2-1).getTotalFlats()));
    }

    public int compareBuildingsTotalArea(int num1, int num2) {
        return(Double.compare(Buildings.get(num1 - 1).getTotalArea(), Buildings.get(num2-1).getTotalArea()));
    }

    public int compareBuildingsTotalResidents(int num1, int num2) {
        return(Integer.compare(Buildings.get(num1 - 1).getTotalResidents(), Buildings.get(num2-1).getTotalResidents()));
    }

    public int compareBuildingsTotalFloors(int num1, int num2) {
        return(Integer.compare(Buildings.get(num1 - 1).getTotalFloors(), Buildings.get(num2-1).getTotalFloors()));
    }

    public int[] compareBuildingsFull(int num1, int num2) throws InputMismatchException{
        int[] comparison = new int[4];
        comparison[0] = this.compareBuildingsTotalFLats(num1, num2);
        comparison[1] = this.compareBuildingsTotalArea(num1, num2);
        comparison[2] = this.compareBuildingsTotalResidents(num1, num2);
        comparison[3] = this.compareBuildingsTotalFloors(num1, num2);
        return comparison;

    }

    public int compareFlatsTotalArea(int num1b, int num1f, int num2b, int num2f) {
        return(Double.compare(Buildings.get(num1b - 1).flatsTotal.get(num1f).getFlatArea(), Buildings.get(num2b-1).flatsTotal.get(num2f).getFlatArea()));
    }

    public int compareFlatsTotalResidents(int num1b, int num1f, int num2b, int num2f) {
        return(Double.compare(Buildings.get(num1b - 1).flatsTotal.get(num1f).getFlatResidents(), Buildings.get(num2b-1).flatsTotal.get(num2f).getFlatResidents()));
    }

    public int[] compareFlatsFull(int num1b, int num1f, int num2b, int num2f) {
        int[] comparison = new int[2];
        comparison[0] = this.compareFlatsTotalArea(num1b, num1f, num2b, num2f);
        comparison[1] = this.compareFlatsTotalResidents(num1b, num1f, num2b, num2f);
        return comparison;
    }

    public void saveToFileSystem() throws IOException {
        if (!new File("Database").mkdir() && !new File("Database").exists())
        {
            throw new IOException();
        }

        for (int i = 0; i < Buildings.size(); i++) {
            try {
                FileWriter writer = new FileWriter("Database/Building" + (i+1) + ".txt");
                writer.write(String.valueOf(this.Buildings.get(i)));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
