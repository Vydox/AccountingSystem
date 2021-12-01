package lab1;


import java.util.*;


public class Building {
    private double totalArea;
    private int totalFloors;
    private int totalFlats;
    private int totalResidents;
    protected List<Floor> floors = new ArrayList<>();
    protected List<Floor.Flat> flats = new ArrayList<>();

    public void setTotalArea(double area) {
        totalArea = area;
    }
    public void setTotalResidents(int residents) {
        totalResidents = residents;
    }
    public void setTotalFlats(int flats) {
        totalFlats = flats;
    }
    public void setTotalFloors(int floors) {
        totalFloors = floors;
    }

    public double getTotalArea() {
        return totalArea;
    }
    public int getTotalResidents() {
        return totalResidents;
    }
    public int getTotalFlats() {
        return totalFlats;
    }
    public int getTotalFloors() {
        return totalFloors;
    }


    public void showTotalFlats() {
        System.out.println("There are " + this.totalFlats + " flats in this building");
    }
    public void showTotalArea() {
        System.out.println("Total area of this building is " + this.totalArea);
    }
    public void showTotalResidents() {
        System.out.println("Total amount of residents of this building is " + this.totalResidents);
    }
    public void showTotalFloors() {
        System.out.println("There are " + this.totalFloors + " floors in this building");
    }

    public Building() {
        totalArea = 0;
        totalFloors = 0;
        totalFlats = 0;
        totalResidents = 0;
    }

    public Building(int flats_amount, int flatsPerFloor) {
        this.totalFlats = flats_amount;
        this.totalArea = 0;
        this.totalResidents = 0;
        System.out.println("Creating building with " + flats_amount + " flats, " + flatsPerFloor + " flats per floor\n");

        this.totalFloors = flats_amount/flatsPerFloor;

        for (int i = 0; i < totalFloors; i++) {
            System.out.println("Setting floor №" + (i+1) + "\n");
            floors.add(new Floor(flatsPerFloor));
            this.totalArea += floors.get(i).floorArea;
            this.totalResidents += floors.get(i).floorResidents;
        }


    }



    public class Floor {
        private int flatsPerFloor;
        private double floorArea;
        private int floorResidents;

        Floor(int fpf) {
            this.flatsPerFloor = fpf;
            this.floorArea = 0;
            this.floorResidents = 0;
            for (int i = 0; i < flatsPerFloor; i++) {
                System.out.println("Setting flat №" + (i+1));
                flats.add(new Flat());
                this.floorArea += flats.get(i).flatArea;
                this.floorResidents += flats.get(i).flatResidents;
                System.out.println("\n");
            }
        }





        public class Flat {
            private int flatResidents;
            private double flatArea;

            Flat() throws InputMismatchException {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter area of this flat: ");
                this.flatArea = in.nextDouble();
                if (flatArea <= 0)
                    throw new InputMismatchException("Incorrect input");
                System.out.print("Enter amount of residents of this flat: ");
                this.flatResidents = in.nextInt();
                if (flatResidents <= 0)
                    throw new InputMismatchException("Incorrect input");
            }

            public double getFlatArea() {
                return flatArea;
            }
            public int getFlatResidents() {
                return flatResidents;
            }
        }
    }
}

