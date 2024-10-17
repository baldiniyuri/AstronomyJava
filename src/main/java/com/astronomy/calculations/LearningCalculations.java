package main.java.com.astronomy.calculations;

import java.util.List;
import java.util.ArrayList;


public class LearningCalculations {
    private double[][] x;
    private double[] w;
    private double[] b;
    private double learningRate;

    public LearningCalculations(double[][] x, double[] w, double[] b, double learningRate) {
        this.x = x;
        this.w = w;
        this.b = b;
        this.learningRate = learningRate;
    }

    public double[] linearModel() {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            z[i] = w[0] * x[i][0];
            z[i] += b[0];
        }
        return z;
    }

    public double[] linearFunction() {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = 2 * x[i][0] - 2;
        }
        return y;
    }

    public double meanSquaredError(double[] yTrue) {
        double[] yPred = linearFunction();
        double mse = 0.0;
        for (int i = 0; i < yTrue.length; i++) {
            mse += Math.pow(yTrue[i] - yPred[i], 2);
        }
        return mse / yTrue.length;
    }

    public void updateWeights(double[] dw) {
        for (int i = 0; i < w.length; i++) {
            w[i] -= learningRate * dw[i];
        }
    }

    public List<double[]> forwardPropagation(double[][][] weights) {
        double[] z = x[0];
        List<double[]> activations = new ArrayList<>();
        activations.add(z);

        for (double[][] weight : weights) {
            z = matrixVectorMultiply(z, weight);
            z = sigmoid(z);
            activations.add(z);
        }
        return activations;
    }

    public double[][] backPropagation(double[] yTrue, double[][][] weights) {
        List<double[]> activations = forwardPropagation(weights);
        double[] deltas = new double[yTrue.length];
        for (int i = 0; i < yTrue.length; i++) {
            deltas[i] = activations.get(activations.size() - 1)[i] - yTrue[i];
        }

        for (int i = weights.length - 1; i >= 0; i--) {
            weights[i] = weightUpdates(weights[i], activations.get(i), deltas);
        }
        return weights[weights.length - 1];
    }

    private double[][] weightUpdates(double[][] weights, double[] activations, double[] deltas) {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] -= learningRate * activations[i] * deltas[j];
            }
        }
        return weights;
    }

    private double[] matrixVectorMultiply(double[] vector, double[][] weight) {
        double[] result = new double[weight[0].length];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                result[j] += vector[i] * weight[i][j];
            }
        }
        return result;
    }

    private double[] sigmoid(double[] z) {
        double[] result = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            result[i] = 1 / (1 + Math.exp(-z[i]));
        }
        return result;
    }

    public static void  startLearning() {
        double[][] x = {{1.0}, {2.0}, {3.0}};
        double[] w = {0.1, 0.2};
        double[] b = {0.3};

        LearningCalculations learningCalc = new LearningCalculations(x, w, b, 0.01);

        double[] z = learningCalc.linearModel();
        System.out.println("Linear model output (z): ");
        for (double val : z) {
            System.out.println(val);
        }

        double[] y = learningCalc.linearFunction();
        System.out.println("Linear function output (y): ");
        for (double val : y) {
            System.out.println(val);
        }

        double[] yTrue = {1.0, 2.0, 3.0};
        double mse = learningCalc.meanSquaredError(yTrue);
        System.out.println("Mean squared error (MSE): " + mse);

        double[] dw = {0.1, 0.2};
        learningCalc.updateWeights(dw);

        double[][][] weights = {
                {{0.1, 0.2}, {0.3, 0.4}},
                {{0.5, 0.6}}
        };

        List<double[]> activations = learningCalc.forwardPropagation(weights);
        System.out.println("Activations: ");
        for (double[] activation : activations) {
            for (double val : activation) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        double[][] updatedWeights = learningCalc.backPropagation(yTrue, weights);
        System.out.println("Updated weights: ");
        for (double[] weight : updatedWeights) {
            for (double val : weight) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
