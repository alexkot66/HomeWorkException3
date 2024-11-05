import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Human {

    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;

    public Human (String[] data) throws IllegalArgumentException {
        if (data.length != 6) { //проверка все ли значения введены, если нет, то прокинуть исключение выше по стеку
            throw new IllegalArgumentException("Неверное количество данных");
        }
        //присваивание ФИО
        this.lastName = data[0];
        this.firstName = data[1];
        this.middleName = data[2];
        // Проверка на правильность введенной даты рождения, если нет, то прокинуть исключение выше по стеку
        try {
            this.birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат даты рождения, введите дд.мм.гггг");
        }
        // Проверка на правильность формата телефона, если нет, то прокинуть исключение выше по стеку
        try {
            this.phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона, ожидается целое число");
        }
        // Проверка на правильность формата указанного пола, если нет, то прокинуть исключение выше по стеку
        if (data[5].length() != 1 || (!data[5].equalsIgnoreCase("f") &&
                !data[5].equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("Неверный формат пола, введите f или m");
        }
        this.gender = data[5].charAt(0);
    }
        // геттер для формирования названия файла с однофамильцами
    public String getLastName() {
        return lastName;
    }
    // переопределение метода toString для корректного получения строки информации о человеке
    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, middleName,
                birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), phoneNumber, gender);
    }

}
