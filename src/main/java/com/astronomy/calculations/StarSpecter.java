package main.java.com.astronomy.calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarSpecter {
    private final String[] StarElements = {"Hydrogen", "Helium", "Carbon", "Iron", "Calcium", "Sodium", "Magnesium", "Oxygen"};
    private double kelvin;
    private List<String> ElementsList;

    public  StarSpecter(double kelvin){
        this.kelvin = kelvin;
        this.ElementsList = new ArrayList<>();
    }

    private List<String> checkElements(){
        if (kelvin >= 20001){
            ElementsList.add(StarElements[0]);
            ElementsList.add(StarElements[1]);
        }
        if (kelvin > 10001 && kelvin < 20000){
            ElementsList.add(StarElements[3]);
            ElementsList.add(StarElements[4]);
        }
        if (kelvin > 7001 && kelvin < 10000){
            ElementsList.add(StarElements[5]);
            ElementsList.add(StarElements[6]);
        }
        if (kelvin > 4001 && kelvin < 6000){
            ElementsList.add(StarElements[6]);
            ElementsList.add(StarElements[7]);
        }
        if (kelvin > 3000 && kelvin < 4000){
            ElementsList.add(StarElements[6]);
            ElementsList.add(StarElements[7]);
        }
        else {
            ElementsList.add(StarElements[2]);
            ElementsList.add(StarElements[7]);
        }
    return ElementsList;
    }

    public static void startStarSpecter(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Star specter elements.");
        System.out.println("Enter the star temperature, using Kelvin.");

        double kelvin = scanner.nextDouble();

        StarSpecter starSpecter = new StarSpecter(kelvin);
        List<String> results = starSpecter.checkElements();

        System.out.println("The star contains the following elements:");

        for (String result: results){
            System.out.println(result);
        }
    }
}

