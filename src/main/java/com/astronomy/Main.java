package main.java.com.astronomy;

import main.java.com.astronomy.calculations.AstronomyCalculations;
import main.java.com.astronomy.calculations.DecayCalculations;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running...");
        System.out.println("Select program.");
        System.out.println("1 For Astronomical Calculations.");
        System.out.println("2 For Spherical Trigonometry.");
        System.out.println("3 For Image Analysis.");
        System.out.println("4 For Zeta Analysis *** under development.");
        System.out.println("5 For Decay Calculations");

        Scanner scanner = new Scanner(System.in);
        int program = scanner.nextInt();

        switch (program) {
            case 1:
                AstronomyCalculations.startAstronomyCalculations();
                break;
            case 2:
                DecayCalculations.startDecayCalculations();
                break;
            default:
                System.out.println("Invalid program input.");
                System.out.println("Terminating program.");
                break;
        }

        scanner.close();
    }


}