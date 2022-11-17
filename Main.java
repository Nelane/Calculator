import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] str;
        String[] sim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int a=0;
        int b=0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = bufferedReader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 10; i < sim.length; i++){
            if(str[0].equals(sim[i]) || str[2].equals(sim[i])){
                throw new Exception("Принимаются числа от I до X включительно");
            }
        }
        //Римские числа
        for (int i = 0; i < 10; i++) {
            if (str[0].equals(sim[i])){
                for (int j = 0; j < 10; j++) {
                    if(str[2].equals(sim[j])){
                        int t = result(i+1,j+1, str[1]);
                        System.out.println(sim[t-1]);
                        System.exit(0);
                    }
                }
            }
        }
        //Арабские числа
        for (int i = 0; i < str.length; i++) {
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[2]);
        }
        if (a < 1 || a > 10 || b < 1 || b > 10){
            throw new Exception("Принимаются числа от 1 до 10 включительно");
        }
        System.out.println(result(a, b, str[1]));
    }

    //Узнать знак и вернуть результат подсчетов
    public static int result(int a, int b, String c) throws Exception {
        int res = switch (c) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> throw new Exception("Арифметическая операция не соответсвует заданию");
        };
        return res;
    }
}