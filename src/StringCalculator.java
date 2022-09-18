public class StringCalculator {//назва програми
    public static String Metacharacters(String del) {//Екранування спеціальних символів регулярних виразів.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < del.length(); i++) {//Цикл
            if (".+?^*$|\\()".indexOf(del.charAt(i)) != -1){//Порівняння
                result.append('\\');
            }
            result.append(del.charAt(i));
        }
        return result.toString();//Конвертація
    }

    public static int Summary(String[] nums){//передаємо масив.
        int sum = 0;
        for(String num : nums) {
            if (num.length() == 0) {num = "0";}
            int number_int = Integer.parseInt(num);//зчитуємо число
            if (number_int < 0) {System.out.println("Negatives are not allowed! Invalid input: " + number_int);}
            else if (number_int <= 1000) {sum += number_int;}
        }
        return sum;//повертаємо суму.
    }

    public static int Add(String numbers){//Передаємо рядок в якому знаходяться розполільники та числа.
        int result;
        String delimiter = "";//Спочатку він пустий
        if(numbers.length() == 0){return 0;}
        if (numbers.toCharArray()[0] == '/' && numbers.toCharArray()[1] == '/') {
            if(numbers.toCharArray()[2] == '[') {//рядок в масив
                String[] dels = numbers.split("//|\\[|]");
                for (int i = 0; i < dels.length - 1; ++i) {
                    if (!dels[i].equals("")) {
                        delimiter += Metacharacters(dels[i]) + "|";
                    }
                }
                String[] nums = numbers.split(delimiter + "\\[|\\]|//|\n|,");
                result = Summary(nums);//розраховуємо суму
            }
            else{
                delimiter += numbers.toCharArray()[2];
                delimiter = Metacharacters(delimiter);
                String[] nums = numbers.split(delimiter + "|//|\n|,");
                result = Summary(nums);//розраховуємо суму
            }
        }
        else{
            String[] nums = numbers.split(",|\n");
            result = Summary(nums);
        }
        return result;
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
