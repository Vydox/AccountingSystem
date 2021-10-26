package lab1;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        AccountingSystem AS = new AccountingSystem();

        System.out.println("Program launched\n");


        while (true) {

            System.out.println("\nWhat do you want to do?");
            System.out.println("See system status ------ 1");
            System.out.println("Add building ----------- 2");
            System.out.println("Delete building -------- 3");
            System.out.println("Get full building info - 4");
            System.out.println("Compare buildings ------ 5");
            System.out.println("Compare flats ---------- 6");
            System.out.println("Exit ------------------- 7\n");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    AS.getFullSystemInfo();
                    break;
                case 2:
                    AS.createBuilding();
                    break;
                case 3:
                    System.out.print("Enter number of building you want to delete: ");
                    int num_del = in.nextInt();
                    AS.deleteBuilding(num_del);
                    break;
                case 4:
                    System.out.print("Enter number of building you want to get info about: ");
                    int num_info = in.nextInt();
                    AS.getFullBuildingInfo(num_info);
                    break;
                case 5:
                    System.out.println("Enter numbers of buildings you want to compare");
                    int num_comp1 = in.nextInt();
                    int num_comp2 = in.nextInt();
                    AS.compareBuildings(num_comp1, num_comp2);
                    break;
                case 6:
                    System.out.println("First flat");
                    System.out.print("Enter number of building of this flat: ");
                    int num_comp_b1 = in.nextInt();
                    System.out.print("Enter number of this flat: ");
                    int num_comp_f1 = in.nextInt();
                    System.out.println("\nSecond flat");
                    System.out.print("Enter number of building of this flat: ");
                    int num_comp_b2 = in.nextInt();
                    System.out.print("Enter number of this flat: ");
                    int num_comp_f2 = in.nextInt();
                    AS.compareFlats(num_comp_b1, num_comp_f1, num_comp_b2, num_comp_f2);
                    break;
                case 7:
                    System.exit(0);


            }
        }


    }
}

