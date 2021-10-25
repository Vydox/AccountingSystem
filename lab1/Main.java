package lab1;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);



        int f_a;
        System.out.println("Enter amount of flats");
        f_a = in.nextInt();

        int fpf;
        System.out.println("Enter number of flats per floor");
        fpf = in.nextInt();


        Building H1 = new Building(f_a, fpf);
        H1.GetTotalResidents();
        H1.GetTotalArea();
        H1.GetTotalFloors();

    }
}

