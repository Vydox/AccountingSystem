package lab1;


import java.util.*;


public class Building {
    private double total_area;
    private int total_floors;
    private int total_flats;
    private int total_residents;
    protected ArrayList<Floor> floors = new ArrayList<>();
    protected ArrayList<Floor.Flat> flats = new ArrayList<>();

    public double getTotalArea() {
        return total_area;
    }
    public int getTotalResidents() {
        return total_residents;
    }
    public int getTotalFlats() {
        return total_flats;
    }
    public int getTotalFloors() {
        return total_floors;
    }


    public void showTotalFlats() {
        System.out.println("There are " + this.total_flats + " flats in this building");
    }
    public void showTotalArea() {
        System.out.println("Total area of this building is " + this.total_area);
    }
    public void showTotalResidents() {
        System.out.println("Total amount of residents of this building is " + this.total_residents);
    }
    public void showTotalFloors() {
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

        Floor(int fpf) {
            this.flats_per_floor = fpf;
            this.floor_area = 0;
            this.floor_residents = 0;
            for (int i = 0; i < flats_per_floor; i++) {
                System.out.println("Setting flat №" + (i+1));
                flats.add(new Flat());
                this.floor_area += flats.get(i).flat_area;
                this.floor_residents += flats.get(i).flat_residents;
                System.out.println("\n");
            }
        }





        public class Flat {
            private int flat_residents;
            private double flat_area;

            Flat() throws InputMismatchException {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter area of this flat: ");
                this.flat_area = in.nextDouble();
                if (flat_area <= 0)
                    throw new InputMismatchException("Incorrect input");
                System.out.print("Enter amount of residents of this flat: ");
                this.flat_residents = in.nextInt();
                if (flat_residents <= 0)
                    throw new InputMismatchException("Incorrect input");
            }

            public double getFlatArea() {
                return flat_area;
            }
            public int getFlatResidents() {
                return flat_residents;
            }
        }
    }
}

