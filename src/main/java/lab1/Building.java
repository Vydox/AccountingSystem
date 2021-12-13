package lab1;


import java.util.*;


public class Building {
    private double totalArea;
    private int totalFloors;
    private int totalFlats;
    private int totalResidents;
    protected List<Floor> floors = new ArrayList<>();
    protected List<Floor.Flat> flatsTotal = new ArrayList<>();

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

    @Override
    public String toString() {
        return this.totalArea + "\n" + this.totalResidents + "\n" + this.totalFlats + "\n" + this.totalFloors;
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

    public Building(int flatsAmount, int flatsPerFloor) {
        this.totalFlats = flatsAmount;
        this.totalArea = 0;
        this.totalResidents = 0;
        this.totalFloors = flatsAmount/flatsPerFloor;

        for (int i = 0; i < totalFloors; i++) {
            floors.add(new Floor(flatsPerFloor));
        }
    }

    public class Floor {
        private int flatsPerFloor;
        private double floorArea;
        private int floorResidents;

        Floor() {
            flatsPerFloor = 0;
            floorArea = 0;
            floorResidents = 0;
        }

        Floor(int fpf) {
            this.flatsPerFloor = fpf;
            this.floorArea = 0;
            this.floorResidents = 0;
            for (int i = 0; i < fpf; i++) {
                flatsTotal.add(new Flat());
            }
        }



        public class Flat {
            private int flatResidents;
            private double flatArea;

            Flat() throws InputMismatchException {
                flatArea = 0;
                flatResidents = 0;
            }

            Flat(int fa, int fr) {
                flatArea = fa;
                flatResidents = fr;
            }

            public void setFlatArea(double flatArea) {
                this.flatArea = flatArea;
                totalArea += flatArea;
            }
            public void setFlatResidents(int flatResidents) {
                this.flatResidents = flatResidents;
                totalResidents += flatResidents;
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

