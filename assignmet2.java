/ File: CalculatorApp.java
import java.util.Scanner;

// -------------------------
// Calculator Class
// -------------------------
class Calculator {

    // Method Overloading for Addition
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division (with exception handling)
    public double divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}

// -------------------------
// User Interface Class
// -------------------------
class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private Calculator calc = new Calculator();

    // Perform Addition
    public void performAddition() {
        System.out.println("Choose addition type:");
        System.out.println("1. Add two integers");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter two integers: ");
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println("Result: " + calc.add(a, b));
                break;

            case 2:
                System.out.print("Enter two doubles: ");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                System.out.println("Result: " + calc.add(x, y));
                break;

            case 3:
                System.out.print("Enter three integers: ");
                int p = sc.nextInt();
                int q = sc.nextInt();
                int r = sc.nextInt();
                System.out.println("Result: " + calc.add(p, q, r));
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    // Perform Subtraction
    public void performSubtraction() {
        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Result: " + calc.subtract(a, b));
    }

    // Perform Multiplication
    public void performMultiplication() {
        System.out.print("Enter two double numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println("Result: " + calc.multiply(a, b));
    }

    // Perform Division
    public void performDivision() {
        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        double result = calc.divide(a, b);
        if (b != 0)
            System.out.println("Result: " + result);
    }

    // Main Menu
    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n--- Welcome to the Calculator Application ---");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Exiting Calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }
}

// -------------------------
// Main Class
// -------------------------
public class CalculatorApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}