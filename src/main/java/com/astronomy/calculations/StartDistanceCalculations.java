package main.java.com.astronomy.calculations;

import java.util.Scanner;

public class StartDistanceCalculations {
    private double luminosity;
    private double brightness;
    private double sunWatts = 3.828e26;

    public StartDistanceCalculations(double luminosity, double brightness ){
        this.luminosity = luminosity;
        this.brightness = brightness;
    }

    public double convertLuminosityFromWattsToSolarLuminosity(){
        return luminosity / sunWatts;
    }

    public double inverseSquare(double LSolar){
        return Math.sqrt(LSolar / (4 * Math.PI * brightness));
    }

    public double calculateStarDistance(){
        double LSolar = convertLuminosityFromWattsToSolarLuminosity();

        return inverseSquare(LSolar);
    }

    public static void startStarDistanceCalculations(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Star Distance Calculation.");

        System.out.println("Enter a value for Luminosity:");
        double luminosity = scanner.nextDouble();

        System.out.println("Enter a value for Brightness:");
        double brightness = scanner.nextDouble();

        StartDistanceCalculations startDistanceCalculations = new StartDistanceCalculations(luminosity, brightness);
        double result = startDistanceCalculations.calculateStarDistance();
        System.out.println("The distance of the star is:"+ result);
    }
}
