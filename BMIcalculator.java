import java.util.Scanner;

public class BMIcalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan berat badan Anda (kg): ");
        double weight = scanner.nextDouble();

        System.out.println("Masukkan tinggi badan Anda (meter): ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);
        System.out.println("Indeks Massa Tubuh (BMI) Anda adalah: " + bmi);
        
        String category = interpretBMI(bmi);
        System.out.println("Kategori BMI Anda adalah: " + category);

        scanner.close();
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 24.9 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
