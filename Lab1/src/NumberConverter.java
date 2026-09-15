import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле позитивне число в десятковій системі: ");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Помилка: число має бути більше нуля!");
            } else {
                String binary = convertToBase(number, 2);
                String octal = convertToBase(number, 8);
                String hex = convertToBase(number, 16);

                System.out.println("Число " + number + " у двійковій системі: " + binary);
                System.out.println("Число " + number + " у вісімковій системі: " + octal);
                System.out.println("Число " + number + " у шістнадцятковій системі: " + hex);
            }
        } else {
            System.out.println("Помилка: введено не ціле число!");
        }

        scanner.close();
    }

    public static String convertToBase(int number, int base) {
        String characters = "0123456789ABCDEF";
        String result = "";

        while (number > 0) {
            int remainder = number % base;
            result = characters.charAt(remainder) + result;
            number = number / base;
        }

        return result;
    }
}