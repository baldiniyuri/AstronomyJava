package main.java.com.astronomy;

import main.java.com.astronomy.calculations.AstronomyCalculations;
import main.java.com.astronomy.calculations.DecayCalculations;
import main.java.com.astronomy.calculations.LearningCalculations;
import main.java.com.astronomy.calculations.StartDistanceCalculations;
import main.java.com.astronomy.calculations.StarSpecter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running...");
        System.out.println("Select program.");
        System.out.println("1 For Astronomical Calculations.");
        System.out.println("2 For Decay Calculations.");
        System.out.println("3 Learning Calculations.");
        System.out.println("4 Star distance calculations.");
        System.out.println("5 Star specter elements.");

        Scanner scanner = new Scanner(System.in);
        int program = scanner.nextInt();

        switch (program) {
            case 1:
                AstronomyCalculations.startAstronomyCalculations();
                break;
            case 2:
                DecayCalculations.startDecayCalculations();
                break;
            case 3:
                LearningCalculations.startLearning();
                break;
            case 4:
                StartDistanceCalculations.startStarDistanceCalculations();
                break;
            case 5:
                StarSpecter.startStarSpecter();
            default:
                System.out.println("Invalid program input.");
                System.out.println("Terminating program.");
                break;
        }

        scanner.close();
    }

}