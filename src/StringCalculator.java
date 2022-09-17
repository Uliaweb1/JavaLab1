import java.util.Arrays;
import java.util.Objects;

public class Lab1 {
    public static String Metacharacters(String del) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < del.length(); i++) {
            if (".+?^*$|\\()".indexOf(del.charAt(i)) != -1){
                result.append('\\');
            }
            result.append(del.charAt(i));
        }
        return result.toString();
    }

    public static int Summary(String[] nums){
        int sum = 0;
        for(String num : nums) {
            if (num.length() == 0) {num = "0";}

            int number_int = Integer.parseInt(num);

            if (number_int < 0) {System.out.println("Negatives are not allowed! Invalid input: " + number_int);}

            else if (number_int <= 1000) {sum += number_int;}
        }
        return sum;
    }

    public static int Add(String numbers){
        int result;
        String delimiter = "";
        if(numbers.length() == 0){return 0;}
        if (numbers.toCharArray()[0] == '/' && numbers.toCharArray()[1] == '/') {
            if(numbers.toCharArray()[2] == '[') {
                String[] dels = numbers.split("//|\\[|]");
                for (int amount = 0; amount < dels.length - 1; ++amount) {
                    if (!dels[amount].equals("")) {
                        delimiter += Metacharacters(dels[amount]) + "|";
                    }
                }
                String[] nums = numbers.split(delimiter + "\\[|\\]|//|\n|,");
                result = Summary(nums);
            }
            else{
                delimiter += numbers.toCharArray()[2];
                delimiter = Metacharacters(delimiter);
                String[] nums = numbers.split(delimiter + "|//|\n|,");
                result = Summary(nums);
            }
        }
        else{
            String[] nums = numbers.split(",|\n");
            result = Summary(nums);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.print("Step 1\n");
        System.out.print("\tSum: " + Add( "") + "\n");
        System.out.print("\tSum: " + Add( "1") + "\n");
        System.out.print("\tSum: " + Add( "1,2") + "\n");
        System.out.print("Step 2\n");
        System.out.print("\tSum: " + Add( "1,2,3,4,5,6,7,8,9,10") + "\n");
        System.out.print("Step 3\n");
        System.out.print("\tSum: " + Add( "1\n2,3") + "\n");
        System.out.print("\tSum: " + Add( "1,\n") + "\n");
        System.out.print("Step 4\n");
        System.out.print("\tSum: " + Add( "//;\n1;2") + "\n");
        System.out.print("Step 5\n");
        System.out.print("\tSum: " + Add( "-11") + "\n");
        System.out.print("Step 6\n");
        System.out.print("\tSum: " + Add( "1000,999,1001") + "\n");
        System.out.print("Step 7\n");
        System.out.print("\tSum: " + Add( "//[**]\n1**2**3") + "\n");
        System.out.print("Step 8\n");
        System.out.print("\tSum: " + Add( "//[*][%]\n1*2%3") + "\n");
        System.out.print("Step 9\n");
        System.out.print("\tSum: " + Add( "//[*][***][**]\n1*2***3**4,5\n6") + "\n");
        System.out.print("\tSum: " + Add( "//[*][%][$+$]\n1*3$+$2%1000,1001\n6") + "\n");
        System.out.print("\tSum: " + Add( "//[*][%][Q][E]\n1Q2E3Q4E5Q6E7Q8E9Q10") + "\n");
    }
}