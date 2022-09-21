import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введіть рядок: ");
        String numbers = new Scanner(System.in).nextLine();
        StringCalculator calc = new StringCalculator();
        try {
            System.out.println("Результат: " + calc.Add(numbers.replaceAll("\\\\n", "\n")));
        } catch (Exception e) {
            System.out.println("Помилка! Не=правильний ввід: " + numbers );
        }
    }
}
