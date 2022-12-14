public class StringCalculator {//назва програми
    private static String Metacharacters(String del) {//Екранування спеціальних символів регулярних виразів.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < del.length(); i++) {//Цикл
            if (".+?^*$|\\()".indexOf(del.charAt(i)) != -1){
                result.append('\\');
            }
            result.append(del.charAt(i));
        }
        return result.toString();//Конвертація
    }

    private static int Summary(String[] nums){//передаємо масив.
        int sum = 0;
        for(String num : nums) {
            if (num.length() == 0) {num = "0";}
            int number_int = Integer.parseInt(num);//зчитуємо число
            if (number_int < 0) {System.out.println("Помилка! Неможливий ввід негативних чисел: " + number_int);}
            else if (number_int <= 1000) {sum += number_int;}
            else System.out.println("Ігноруються числа більше 1000: " + number_int);
        }
        return sum;//повертаємо суму.
    }

    public static int Add(String numbers){//Передаємо рядок в якому знаходяться розполільники та числа.
        if(numbers.length() == 0){return 0;}
        if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
            if(numbers.charAt(2) == '[') {//рядок в масив
                StringBuilder delimiter = new StringBuilder();//Спочатку він пустий
                String[] dels = numbers.split("//|\\[|]");
                for (int i = 0; i < dels.length - 1; ++i) {
                    if (!dels[i].equals("")) {
                        delimiter.append(Metacharacters(dels[i])).append("|");
                    }
                }
                return Summary(numbers.split(delimiter + "\\[|]|//|\n|,"));//розраховуємо суму
            }
            else{
                String delimiter = Metacharacters(String.valueOf(numbers.charAt(2)));
                return Summary(numbers.split(delimiter + "|//|\n|,"));//розраховуємо суму
            }
        }
        else{
            return Summary(numbers.split("[,\n]"));
        }
    }

    public static void main(String[] args){//візуальна перевірка всіх тестів
        System.out.println("Step 1");
        System.out.println("\tSum: " + Add( ""));
        System.out.println("\tSum: " + Add( "1"));
        System.out.println("\tSum: " + Add( "1,2"));
        System.out.println("Step 2");
        System.out.println("\tSum: " + Add( "1,2,3,4,5,6,7,8,9,10"));
        System.out.println("Step 3");
        System.out.println("\tSum: " + Add( "1\n2,3"));
        System.out.println("\tSum: " + Add( "1,\n"));
        System.out.println("Step 4");
        System.out.println("\tSum: " + Add( "//;\n1;2"));
        System.out.println("Step 5");
        System.out.println("\tSum: " + Add( "-11"));
        System.out.println("Step 6");
        System.out.println("\tSum: " + Add( "1000,999,1001"));
        System.out.println("Step 7");
        System.out.println("\tSum: " + Add( "//[**]\n1**2**3"));
        System.out.println("Step 8");
        System.out.println("\tSum: " + Add( "//[*][%]\n1*2%3"));
        System.out.println("Step 9");
        System.out.println("\tSum: " + Add( "//[*][***][**]\n1*2***3**4,5\n6"));
        System.out.println("\tSum: " + Add( "//[*][%][$+$]\n1*3$+$2%1000,1001\n6"));
        System.out.println("\tSum: " + Add( "//[*][%][Q][E]\n1Q2E3Q4E5Q6E7Q8E9Q10"));
    }
}
