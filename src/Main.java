import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введіть рядок: ");
        String numbers = new Scanner(System.in).nextLine().replaceAll("\\\\n","\n");
        StringCalculator calc = new StringCalculator();
        System.out.println("Результат: " + calc.Add(numbers));
    }
}
