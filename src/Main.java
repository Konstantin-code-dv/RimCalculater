
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арабские или римские цифры и арифметический знак");
        String input = scanner.nextLine();
        calculate(input);
    }

    public static void calculate(String input) throws Exception {
        String oper = checSing(input);
        //Проверка через метод что у нас введен правильный знак.
        if (checSing(input) == null) {
            throw new Exception(" т.к. строка не является математической операцией");
        }
        //Разделим по знаку на массив строк,чтобы проверить что ввели 2 символа
        String[] rezult = input.split("[+\\-*/]");
        if (rezult.length != 2) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и знак");
        }
        if(Rim.isRim(rezult[0]) && Rim.isRim(rezult[1])){
            int answer = 0;
            int number1 = Rim.changeRim(rezult[0]);
            int number2 = Rim.changeRim(rezult[1]);
           //Если арабские цифры то проверка что они в диапазоне от 1 до 10
            if ((number1 < 1 || number1 > 10 && number2 < 1 || number2 > 10))
                throw new Exception("Числа должны быть от 1 до 10 включительно");
            switch (oper) {
                case "+":
                    answer = number1 + number2;
                    System.out.println(Rim.convertRim(answer));
                    break;
                case "-":
                    if(number1 - number2 < 1){throw new Exception("т.к. в римской системе нет отрицательных чисел");
                    }
                    else{
                        answer = number1 - number2;
                        System.out.println(Rim.convertRim(answer));
                        break;
                    }

                case "*":
                    answer = number1 * number2;
                    System.out.println(Rim.convertRim(answer));
                    break;
                case "/":
                    answer = number1 / number2;
                    System.out.println(Rim.convertRim(answer));
                    break;
            }
        } else if (!Rim.isRim(rezult[0]) && !Rim.isRim(rezult[1])) {

            int number1 = Integer.parseInt(rezult[0]);
            int number2 = Integer.parseInt(rezult[1]);
            switch (oper) {
                case "+":
                    System.out.println( number1 + number2);
                    break;
                case "-":
                    System.out.println(number1-number2);
                    break;
                case "*":
                    System.out.println(number1 * number2);
                    break;
                case "/":
                    System.out.println(number1 / number2);
                    break;
            }

        }else {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }

    }

    public static String checSing(String text) {
        if (text.contains("+")) return "+";
        else if (text.contains("-")) return "-";
        else if (text.contains("*")) return "*";
        else if (text.contains("/")) return "/";
        else
            return null;

    }

    public static boolean isArabicNumber(String input) {
        return input.matches("\\d+");
    }

}

    class Rim {
        static String[] romanArray = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static boolean isRim(String text){
            for (int i = 0; i < romanArray.length; i++) {
                if(text.equals(romanArray[i])){
                    return true;
                }
            }return false;
        }

        public static int changeRim(String text){
            for (int i = 0; i < romanArray.length ; i++) {
                if(text.equals(romanArray[i]))
                    return i;
            }
            return -1;
        }
        public static String convertRim(int rezult){
            return romanArray[rezult];
        }

    }

