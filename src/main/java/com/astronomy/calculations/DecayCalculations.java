package main.java.com.astronomy.calculations;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecayCalculations {
    private static final Map<String, Double> ELEMENTS_SAMPLE = new HashMap<String, Double>() {{
        put("Uranium-238", 1.54e-10);
        put("Uranium-235", 9.85e-10);
        put("Thorium-232", 4.95e-11);
        put("Potassium-40", 5.543e-10);
        put("Carbon-14", 0.000121);
        put("Rubidium-87", 1.42e-11);
    }};

    private double undecayedAtoms;
    private double originalAtoms;
    private double decayConstant;

    public DecayCalculations(double N, double NO, double decayConstant){
        this.undecayedAtoms = N;
        this.originalAtoms = NO;
        this.decayConstant = decayConstant;
    }

    private void verifyValue(){
        if (undecayedAtoms <= 0 || originalAtoms <= 0 || decayConstant <= 0) {
            throw new IllegalArgumentException("All input values should be positive and non-zero.");
        }
    }

    private double calculateAge(){
        verifyValue();
        return Math.log((originalAtoms / undecayedAtoms) /decayConstant);
    }

    private String formatAgeResult(double result){
        double ageRounded = Math.round(result * 100.0) / 100.0;

        if (result >= 1e9) {
            return String.format("%.2f billion years", result / 1e9);
        } else if (result >= 1e6) {
            return String.format("%.2f million years", result / 1e6);
        } else {
            return String.format("%.2f years", ageRounded);
        }
    }

    public static void startDecayCalculations () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Decay Elements");
        System.out.println("Element Sample");

        for (Map.Entry<String, Double> entry : ELEMENTS_SAMPLE.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Enter a value for Undecayed Atoms");
        double n = scanner.nextDouble();

        System.out.println("Enter a value for the Original Atoms count");
        double no = scanner.nextDouble();

        System.out.println("Enter a value for Element Decay");
        double decayConstant = scanner.nextDouble();

        DecayCalculations decayCalculations  = new DecayCalculations(n, no, decayConstant);
        double result = decayCalculations.calculateAge();
        String age = decayCalculations.formatAgeResult(result);
        System.out.println("Age of sample if:"+ age);
    }
}
