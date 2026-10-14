import java.time.LocalDate;

public class Student {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String phone;
    private Address address;

    public Student(String lastName, String firstName, LocalDate birthDate, String phone, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Студент: %s %s | Дата народження: %s | Телефон: %s | Адреса: %s",
                lastName, firstName, birthDate, phone, address.toString());
    }
}