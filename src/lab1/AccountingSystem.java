package lab1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountingSystem {

    protected ArrayList<Building> Buildings = new ArrayList<>();

    public void status() {
        System.out.println("There are " + Buildings.size() + " buildings in your system\n");
    }

    public void createBuilding() throws InputMismatchException {
        try {
            System.out.println("Creating new building...\n");
            Scanner in = new Scanner(System.in);
            int f_a;
            System.out.println("Enter amount of flats");
            f_a = in.nextInt();
            if (f_a <= 0)
                throw new InputMismatchException("Incorrect input: wrong amount of flats");

            int fpf;
            System.out.println("Enter number of flats per floor");
            fpf = in.nextInt();
            if (fpf <= 0)
                throw new InputMismatchException("Incorrect input: wrong amount of flats per floor");

            if (f_a % fpf == 0) {
                Buildings.add(new Building(f_a, fpf));
                System.out.println("New building is successfully created");
            } else System.out.println("Incorrect input");
        } catch(InputMismatchException e) {
            System.err.println("Error: incorrect input. Command terminated, please try again");
        }
    }

    public void deleteBuilding(int num) {
        if (num > 0 && num <= Buildings.size()) {
            System.out.println("Deleting building " + num + "...");
            Buildings.remove(num - 1);
            System.out.println("Building " + num + " has been successfully deleted");
        } else System.out.println("Incorrect input: there is no building with such number");
    }

    public void getFullBuildingInfo(int num) {
        if (num > 0 && num <= Buildings.size()) {
            System.out.println("Building " + num);
            Buildings.get(num - 1).showTotalFlats();
            Buildings.get(num - 1).ShowTotalArea();
            Buildings.get(num - 1).ShowTotalResidents();
            Buildings.get(num - 1).ShowTotalFloors();
        } else System.out.println("Incorrect input: there is no building with such number");
    }

    public void getFullSystemInfo() {
        status();
        if (Buildings.size() != 0) {
            for (int i = 1; i <= Buildings.size(); i++) {
                getFullBuildingInfo(i);
                System.out.println("\n");
            }
        }
    }

    public void compareBuildings(int num1, int num2) throws InputMismatchException{
        try {
            if (num1 <= 0 || num1 > Buildings.size() || num2 <= 0 || num2 > Buildings.size())
                throw new InputMismatchException();
            //Comparing area
            if (Buildings.get(num1 - 1).GetTotalArea() > Buildings.get(num2 - 1).GetTotalArea()) {
                System.out.println("Building " + num1 + " is bigger than building " + num2);
            } else if (Buildings.get(num1 - 1).GetTotalArea() < Buildings.get(num2 - 1).GetTotalArea()) {
                System.out.println("Building " + num2 + " is bigger than building " + num1);
            } else System.out.println("Building " + num1 + " and building " + num2 + " have the same area");


            //Comparing amount of residents
            if (Buildings.get(num1 - 1).GetTotalResidents() > Buildings.get(num2 - 1).GetTotalResidents()) {
                System.out.println("Building " + num1 + " has more residents than building " + num2);
            } else if (Buildings.get(num1 - 1).GetTotalResidents() < Buildings.get(num2 - 1).GetTotalResidents()) {
                System.out.println("Building " + num2 + " has more residents than building " + num1);
            } else
                System.out.println("Building " + num1 + " and building " + num2 + " have the same amount of residents");

            //Comparing amount of floors
            if (Buildings.get(num1 - 1).GetTotalFloors() > Buildings.get(num2 - 1).GetTotalFloors()) {
                System.out.println("Building " + num1 + " is higher than building " + num2);
            } else if (Buildings.get(num1 - 1).GetTotalFloors() < Buildings.get(num2 - 1).GetTotalFloors()) {
                System.out.println("Building " + num2 + " is higher than building " + num1);
            } else System.out.println("Building " + num1 + " and building " + num2 + " have the same height");
        } catch (InputMismatchException e) {
            System.err.println("Error: incorrect input. Command terminated, please try again");
        }
    }

    public void compareFlats(int BNum1, int FNum1, int BNum2, int FNum2) {
        try {
            if (BNum1 <= 0 || BNum1 > Buildings.size() || BNum2 <= 0 || BNum2 > Buildings.size())
                throw new InputMismatchException();
            if (FNum1 <= 0 || FNum1 > Buildings.get(BNum1 - 1).flats.size() || FNum2 <= 0 || FNum2 > Buildings.get(BNum2 - 1).flats.size())
                throw new InputMismatchException();
            //Comparing area
            if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).GetFlatArea() > Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).GetFlatArea()) {
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " is bigger than flat " + FNum2 + " of building " + BNum2);
            } else if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).GetFlatArea() < Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).GetFlatArea()) {
                System.out.println("Flat " + FNum2 + " of building " + BNum2 + " is bigger than flat " + FNum1 + " of building " + BNum1);
            } else
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " and flat " + FNum2 + " of building " + BNum2 + " have the same area");


            //Comparing amount of residents
            if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).GetFlatResidents() > Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).GetFlatResidents()) {
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " has more residents than flat " + FNum2 + " of building " + BNum2);
            } else if (Buildings.get(BNum1 - 1).flats.get(FNum1 - 1).GetFlatResidents() < Buildings.get(BNum2 - 1).flats.get(FNum2 - 1).GetFlatResidents()) {
                System.out.println("Flat " + FNum2 + " of building " + BNum2 + " has more residents than flat " + FNum1 + " of building " + BNum1);
            } else
                System.out.println("Flat " + FNum1 + " of building " + BNum1 + " and flat " + FNum2 + " of building " + BNum2 + " have the same amount of residents");
        }catch (InputMismatchException e) {
            System.err.println("Error: incorrect input. Command terminated, please try again");
        }
    }

}
