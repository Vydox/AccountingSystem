package lab1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountingSystem {

    public List<Building> Buildings = new ArrayList<>();

    public void createBuilding() {
        Buildings.add(new Building());
    }

    public void createBuilding(int fl, int fpf) {
        Buildings.add(new Building(fl, fpf));
    }

    public void deleteBuilding(int num) {
        Buildings.remove(num - 1);
    }

    public int getBuildingsAmount() {
        return Buildings.size();
    }

    public void getFullBuildingInfo(int num) {
        if (num > 0 && num <= Buildings.size()) {
            System.out.println("Building " + num);
            Buildings.get(num - 1).showTotalFlats();
            Buildings.get(num - 1).showTotalArea();
            Buildings.get(num - 1).showTotalResidents();
            Buildings.get(num - 1).showTotalFloors();
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
        /*try {
            if (num1 <= 0 || num1 > Buildings.size() || num2 <= 0 || num2 > Buildings.size())
                throw new InputMismatchException();
            //Comparing amount of flats
            if (Buildings.get(num1 - 1).getTotalFlats() > Buildings.get(num2 - 1).getTotalFlats()) {
                System.out.println("Building " + num1 + " has more flats than building " + num2);
            } else if (Buildings.get(num1 - 1).getTotalFlats() < Buildings.get(num2 - 1).getTotalFlats()) {
                System.out.println("Building " + num2 + " has more flats than building " + num1);
            } else System.out.println("Building " + num1 + " and building " + num2 + " have the same amount of flats");

            //Comparing area
            if (Buildings.get(num1 - 1).getTotalArea() > Buildings.get(num2 - 1).getTotalArea()) {
                System.out.println("Building " + num1 + " is bigger than building " + num2);
            } else if (Buildings.get(num1 - 1).getTotalArea() < Buildings.get(num2 - 1).getTotalArea()) {
                System.out.println("Building " + num2 + " is bigger than building " + num1);
            } else System.out.println("Building " + num1 + " and building " + num2 + " have the same area");


            //Comparing amount of residents
            if (Buildings.get(num1 - 1).getTotalResidents() > Buildings.get(num2 - 1).getTotalResidents()) {
                System.out.println("Building " + num1 + " has more residents than building " + num2);
            } else if (Buildings.get(num1 - 1).getTotalResidents() < Buildings.get(num2 - 1).getTotalResidents()) {
                System.out.println("Building " + num2 + " has more residents than building " + num1);
            } else
                System.out.println("Building " + num1 + " and building " + num2 + " have the same amount of residents");

            //Comparing amount of floors
            if (Buildings.get(num1 - 1).getTotalFloors() > Buildings.get(num2 - 1).getTotalFloors()) {
                System.out.println("Building " + num1 + " is higher than building " + num2);
            } else if (Buildings.get(num1 - 1).getTotalFloors() < Buildings.get(num2 - 1).getTotalFloors()) {
                System.out.println("Building " + num2 + " is higher than building " + num1);
            } else System.out.println("Building " + num1 + " and building " + num2 + " have the same height");
        } catch (InputMismatchException e) {
            System.err.println("Error: incorrect input. Command terminated, please try again");
        }*/

        int[] comparison = new int[4];
        comparison[0] = this.compareBuildingsTotalFLats(num1, num2);
        comparison[1] = this.compareBuildingsTotalArea(num1, num2);
        comparison[2] = this.compareBuildingsTotalResidents(num1, num2);
        comparison[3] = this.compareBuildingsTotalFloors(num1, num2);
        return comparison;

    }

    public int compareFlatsTotalArea(int num1b, int num1f, int num2b, int num2f) {
        return(Double.compare(Buildings.get(num1b - 1).flats.get(num1f).getFlatArea(), Buildings.get(num2b-1).flats.get(num2f).getFlatArea()));
    }

    public int compareFlatsTotalResidents(int num1b, int num1f, int num2b, int num2f) {
        return(Double.compare(Buildings.get(num1b - 1).flats.get(num1f).getFlatResidents(), Buildings.get(num2b-1).flats.get(num2f).getFlatResidents()));
    }

    public int[] compareFlatsFull(int num1b, int num1f, int num2b, int num2f) {
        /*try {
            if (BNum1 <= 0 || BNum1 > Buildings.size() || BNum2 <= 0 || BNum2 > Buildings.size())
                throw new InputMismatchException();
            if (FNum1 <= 0 || FNum1 > Buildings.get(BNum1 - 1).flats.size() || FNum2 <= 0 || FNum2 > Buildings.get(BNum2 - 1).flats.size())
                throw new InputMismatchException();
            //Comparing area
            if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).getFlatArea() > Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).getFlatArea()) {
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " is bigger than flat " + FNum2 + " of building " + BNum2);
            } else if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).getFlatArea() < Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).getFlatArea()) {
                System.out.println("Flat " + FNum2 + " of building " + BNum2 + " is bigger than flat " + FNum1 + " of building " + BNum1);
            } else
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " and flat " + FNum2 + " of building " + BNum2 + " have the same area");


            //Comparing amount of residents
            if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).getFlatResidents() > Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).getFlatResidents()) {
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " has more residents than flat " + FNum2 + " of building " + BNum2);
            } else if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).getFlatResidents() < Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).getFlatResidents()) {
                System.out.println("Flat " + FNum2 + " of building " + BNum2 + " has more residents than flat " + FNum1 + " of building " + BNum1);
            } else
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " and flat " + FNum2 + " of building " + BNum2 + " have the same amount of residents");
        }catch (InputMismatchException e) {
            System.err.println("Error: incorrect input. Command terminated, please try again");
        }*/
        int[] comparison = new int[2];
        comparison[0] = this.compareFlatsTotalArea(num1b, num1f, num2b, num2f);
        comparison[1] = this.compareFlatsTotalResidents(num1b, num1f, num2b, num2f);
        return comparison;
    }

}
