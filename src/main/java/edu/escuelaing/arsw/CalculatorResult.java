package edu.escuelaing.arsw;

public class CalculatorResult {
    private static CalculatorResult instance;
    private double result;

    private CalculatorResult() {
        result = 0.0;
    }

    public static synchronized CalculatorResult getInstance() {
        if (instance == null) {
            instance = new CalculatorResult();
        }
        return instance;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void add(double number) {
        this.result += number;
    }

    public void subtract(double number) {
        this.result -= number;
    }

    public void multiply(double number) {
        this.result *= number;
    }

    public void divide(double number) {
        if (number != 0) {
            this.result /= number;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void clear() {
        this.result = 0.0;
    }
}
