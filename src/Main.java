import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try (FileWriterService fileWriterService = new FileWriterService()) {
                System.out.println("Введите данные в порядке (Фамилия Имя Отчество Дата_рождения Номер_телефона Пол):");
                String inputLine = scanner.nextLine();
                String[] inputData = inputLine.split("\\s+");

                if (inputData.length != 6) {
                    throw new IllegalArgumentException("Неверное количество данных. Ожидалось 6, получено " + inputData.length);
                }

                Human human = new Human(inputData);
                fileWriterService.writeToHumanFile(human);

                System.out.println("Данные записаны.");
            } catch (Exception e) {
                System.out.println("Сообщение об ошибке: " + e.getMessage());
            }

            System.out.println("Хотите продолжить ввод данных? Введите: 1 - да, 2 - нет:");
            String continueInput = scanner.nextLine();
            if (!continueInput.equals("1")) {
                flag = false;
                System.out.println("До новых встреч");
            }
        }
        scanner.close();
    }
}
