import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temp = sc.nextDouble();

        System.out.print("Enter unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = Character.toUpperCase(sc.next().charAt(0));

        switch (unit) {
            case 'C':
                double f = (temp * 9 / 5) + 32;
                double k = temp + 273.15;
                System.out.printf("%.2f°C = %.2f°F = %.2fK%n", temp, f, k);
                break;

            case 'F':
                double c = (temp - 32) * 5 / 9;
                double k2 = c + 273.15;
                System.out.printf("%.2f°F = %.2f°C = %.2fK%n", temp, c, k2);
                break;

            case 'K':
                double c2 = temp - 273.15;
                double f2 = (c2 * 9 / 5) + 32;
                System.out.printf("%.2fK = %.2f°C = %.2f°F%n", temp, c2, f2);
                break;

            default:
                System.out.println("Invalid unit! Please enter C, F, or K.");
        }

        sc.close();
    }
}
