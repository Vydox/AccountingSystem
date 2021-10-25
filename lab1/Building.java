package lab1;


import java.util.ArrayList;
import java.util.Scanner;




public class Building {
    private double total_area;
    private int total_floors;
    private int total_flats;
    private int total_residents;
    private ArrayList<Floor> floors = new ArrayList<Floor>();


    public void GetTotalArea() {
        System.out.println("Total area of this building is " + this.total_area);
    }
    public void GetTotalResidents() {
        System.out.println("Total amount of residents of this building is " + this.total_residents);
    }
    public void GetTotalFloors() {
        System.out.println("There are " + this.total_floors + " floors in this building");
    }

    Building(int flats_amount, int flats_per_floor) {
        this.total_flats = flats_amount;
        this.total_area = 0;
        this.total_residents = 0;
        System.out.println("Creating building with " + flats_amount + " flats, " + flats_per_floor + " flats per floor\n");

        this.total_floors = flats_amount/flats_per_floor;

        for (int i = 0; i < total_floors; i++) {
            System.out.println("Setting floor №" + (i+1) + "\n");
            floors.add(new Floor(flats_per_floor));
            this.total_area += floors.get(i).floor_area;
            this.total_residents += floors.get(i).floor_residents;
        }


    }



    public class Floor {
        private int flats_per_floor;
        private double floor_area;
        private int floor_residents;
        private ArrayList<Flat> flats = new ArrayList<Flat>();

        Floor(int fpf) {
            this.flats_per_floor = fpf;
            this.floor_area = 0;
            this.floor_residents = 0;
            for (int i = 0; i < flats_per_floor; i++) {
                System.out.println("Setting flat №" + (i+1));
                flats.add(new Flat());
                this.floor_area += flats.get(i).flat_area;
                this.floor_residents += flats.get(i).residents_amount;
                System.out.println("\n");
            }
        }





        public class Flat {
            private final int residents_amount;
            private final double flat_area;

            Flat() {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter area of this flat: ");
                this.flat_area = in.nextDouble();
                System.out.print("Enter amount of residents of this flat: ");
                this.residents_amount = in.nextInt();
            }
        }
    }
}

