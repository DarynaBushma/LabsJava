import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> journal = new ArrayList<>();

        System.out.println("=== Журнал куратора ===");

        while (true) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Додати нового студента");
            System.out.println("2. Показати всі записи журналу");
            System.out.println("3. Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewStudent(scanner, journal);
                    break;
                case "2":
                    showAllStudents(journal);
                    break;
                case "3":
                    System.out.println("Вихід з програми...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір. Будь ласка, введіть 1, 2 або 3.");
            }
        }
    }

    private static void addNewStudent(Scanner scanner, List<Student> journal) {
        System.out.println("\n--- Введення даних студента ---");

        String lastName = readAndValidate(scanner, "Введіть прізвище: ",
                "^[А-ЯІЇЄҐа-яіїєґA-Za-z'\\-]+$", "Прізвище має містити лише літери (можливо через дефіс).");

        String firstName = readAndValidate(scanner, "Введіть ім'я: ",
                "^[А-ЯІЇЄҐа-яіїєґA-Za-z']+$", "Ім'я має містити лише літери.");

        String phone = readAndValidate(scanner, "Введіть телефон (у форматі +380...): ",
                "^\\+380\\d{9}$", "Невірний формат. Телефон має починатися з +380 і містити 13 символів.");

        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Введіть дату народження (РРРР-ММ-ДД, наприклад 2005-12-31): ");
            String dateInput = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Помилка: Неправильний формат дати або такої дати не існує. Спробуйте ще раз.");
            }
        }

        System.out.println("--- Введення адреси ---");

        String street = readAndValidate(scanner, "Введіть вулицю: ",
                "^.+$", "Назва вулиці не може бути порожньою.");

        String building = readAndValidate(scanner, "Введіть номер будинку: ",
                "^[0-9]+[А-Яа-яA-Za-z]?$", "Будинок має містити цифри (допускається літера в кінці, наприклад 12А).");

        String apartment = readAndValidate(scanner, "Введіть номер квартири (або '-' якщо приватний будинок): ",
                "^.+$", "Це поле не може бути порожнім.");

        Address address = new Address(street, building, apartment);
        Student student = new Student(lastName, firstName, birthDate, phone, address);

        journal.add(student);
        System.out.println("\nСтудента успішно додано до журналу!");
    }

    private static void showAllStudents(List<Student> journal) {
        System.out.println("\n=== Список студентів у журналі ===");
        if (journal.isEmpty()) {
            System.out.println("Журнал наразі порожній.");
        } else {
            for (int i = 0; i < journal.size(); i++) {
                System.out.println((i + 1) + ". " + journal.get(i).toString());
            }
        }
    }

    private static String readAndValidate(Scanner scanner, String prompt, String regex, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("Помилка: " + errorMessage);
            }
        }
    }
}