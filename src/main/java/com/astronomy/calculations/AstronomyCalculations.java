package main.java.com.astronomy.calculations;

import java.util.Scanner;

public class AstronomyCalculations {
    private double astronomicalUnity;
    private double lightYear;
    private double parsec;

    public AstronomyCalculations(double au, double ly, double parsec) {
        this.astronomicalUnity = au;
        this.lightYear = ly;
        this.parsec = parsec;
    }

    public double lightYearToKilometers() {
        double formula = 9.461e+12;
        return formula * lightYear;
    }

    public double astronomicalUnityToLightYear() {
        double formula = 63240;
        return formula * astronomicalUnity;
    }

    public double astronomicalUnityToParsec() {
        double formula = 206300;
        return formula / parsec;
    }

    public static double binaryStarMass(double a, double p) {
        double G = 6.67430e-11;
        return 4 * Math.pow(Math.PI, 2) * Math.pow(a, 3) / (G * Math.pow(p,2));
    }

    public double convertPeriodToSeconds(int period){
        return period * 365.25 * 24 * 3600;
    }

    public static void startAstronomyCalculations() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Astronomy Calculations.");
        System.out.println("Please, enter a value for Astronomical Units:");
        double au = scanner.nextDouble();
        System.out.println("Please, enter a value for Light Years:");
        double ly = scanner.nextDouble();
        System.out.println("Please, enter a value for parsec:");
        double parsec = scanner.nextDouble();

        System.out.println("Please, choose conversion method:");
        System.out.println("1 for Light year to kilometers conversion.");
        System.out.println("2 for Astronomical unity to light year conversion.");
        System.out.println("3 for Astronomical unity to parsec.");
        System.out.println("4 for Binary Mass Calculator.");
        int program = scanner.nextInt();

        AstronomyCalculations astronomyCalculations = new AstronomyCalculations(au, ly, parsec);

        switch (program) {
            case 1:
                double resultKilometers = astronomyCalculations.lightYearToKilometers();
                System.out.println("The result of conversion of " + ly + " light years to kilometers is " + resultKilometers);
                break;
            case 2:
                double resultLightYear = astronomyCalculations.astronomicalUnityToLightYear();
                System.out.println("The result of conversion of " + au + " astronomical units to light year is " + resultLightYear);
                break;
            case 3:
                double resultParsec = astronomyCalculations.astronomicalUnityToParsec();
                System.out.println("The result of conversion of " + au + " astronomical units to parsec is " + resultParsec);
                break;
            case 4:
                System.out.println("Binary Mass Calculator");
                System.out.println("Enter a value for the semi-major axis (in meters):");
                double axis = scanner.nextDouble();
                System.out.println("Enter the orbital period value in years:");
                int period = scanner.nextInt();
                double orbitalPeriod = astronomyCalculations.convertPeriodToSeconds(period);
                double binaryMassResult = binaryStarMass(axis, orbitalPeriod);
                System.out.println("Combined mass of the binary star system is " + binaryMassResult + " kg");
                break;
            default:
                System.out.println("Invalid program input.");
                System.out.println("End of program...");
                break;
        }

        scanner.close();
    }
}
