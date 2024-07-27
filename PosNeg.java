import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        system.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number > 0) {
            system.out.println("Positive");
        } else if (number < 0) {
            system.out.println("Negative");
        } else {
            system.out.println("Zero");
        }
        
        scanner.close();
    }
}
