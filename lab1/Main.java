package lab1;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);



        AccountingSystem AS = new AccountingSystem();

        AS.CreateBuilding();

        AS.CreateBuilding();

        AS.CreateBuilding();

        AS.getFullSystemInfo();


    }
}

