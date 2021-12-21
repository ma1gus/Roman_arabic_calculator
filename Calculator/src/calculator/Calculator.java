package calculator;

import java.awt.*;
import java.util.*;

public class Calculator {

    public static int Operations(String sign, int a, int b) {

        int res = 0;

        switch (sign) {

            case ("+"):
                res = a + b;
                break;
            case ("-"):
                res = a - b;
                break;
            case ("/"):
                res = a / b;
                break;
            case ("*"):
                res = a * b;
                break;
        }
        return res;
    }

    public static int roman_arabic(String converterRomArab) {

        String[] romanNumb = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        //Проверка на соответствие числу элемента массива
        int n = 0;

        for (int i = 0; i <= 100; i++) {

            if (converterRomArab.equals(romanNumb[i])) {
                n = i;
                i = 100;
            }
        }

        if (n == 0) {
            //Преобразование строки в чило
            n = Integer.parseInt(converterRomArab);
        }
        return (n);
    }

    public static String arabic_roman(int converterArabRom) {

        String[] romanNumb = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return (romanNumb[converterArabRom]);
    }

    //Проверка соответствует ли вводимое число римскому
    public static boolean romanCheck(String stringRoman) {

        HashSet<String> romanSet = new HashSet<>();
        romanSet.add("I");
        romanSet.add("V");
        romanSet.add("X");
        romanSet.add("C");
        romanSet.add("L");
        romanSet.add("D");
        romanSet.add("M");

        boolean booleanResultRoman = true;

        for (int i = 0; i < stringRoman.length(); i++) {
            if (!(romanSet.contains(("" + stringRoman.charAt(i))))) {

                booleanResultRoman = false;
                break;
            }
        }
        return booleanResultRoman;
    }

    //Проверка соответствует ли вводимое число римскому
    public static boolean arabicCheck(String stringArabic) {

        HashSet<String> arabicSet = new HashSet<>();
        arabicSet.add("1");
        arabicSet.add("2");
        arabicSet.add("3");
        arabicSet.add("4");
        arabicSet.add("5");
        arabicSet.add("6");
        arabicSet.add("7");
        arabicSet.add("8");
        arabicSet.add("9");
        arabicSet.add("0");

        boolean booleanResultArabic = true;

        for (int i = 0; i < stringArabic.length(); i++) {
            if (!(arabicSet.contains(("" + stringArabic.charAt(i))))) {
                
                booleanResultArabic = false;
                break;
            }
        }
        return booleanResultArabic;
    }

    public static void main(String[] args) {

        while (true) {

            while (true) {
                System.out.println("Введите арабские или римские цифры для вычислений");
                int error = 0;//Проверка на ошибки
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                input = input.trim();//Удаление лишних пробелов с начала и конца строки
                String[] check = input.split(" ");//Деление строки на части для проверки
                //Импортируем операнд из массива
                String s1 = check[0];
                String operation = check[1];
                String s2 = check[2];
                //Проверка размера строки
                if (check.length > 3) {

                    error++;
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                if (error > 0) {

                    break;
                }

                if (check.length <= 2) {

                    error++;
                    System.out.println("Cтрока не является математической операцией");
                }
                if (error > 0) {

                    break;
                }
                //Проверка на длинну выражения
                if (!(input.replace(" ", "").equals((s1 + operation + s2)))) {

                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    error++;
                }
                if (error > 0) {

                    break;
                }

                //Проверка на полноту вводимой информации
                if ((s1.length() == 0) || (s2.length() == 0) || (operation.length() == 0)) {

                    System.out.println("Cтрока не является математической операцией");
                    error++;
                }
                if (error > 0) {

                    break;
                }
                //Проверка выражения на допустимые символы
                String expression = s1 + operation + s2;
                HashSet<String> charSet = new HashSet<>();
                charSet.add("0");
                charSet.add("1");
                charSet.add("2");
                charSet.add("3");
                charSet.add("4");
                charSet.add("5");
                charSet.add("6");
                charSet.add("7");
                charSet.add("8");
                charSet.add("9");
                charSet.add(" ");
                charSet.add("I");
                charSet.add("V");
                charSet.add("X");
                charSet.add("C");
                charSet.add("L");
                charSet.add("D");
                charSet.add("M");
                charSet.add("+");
                charSet.add("-");
                charSet.add("*");
                charSet.add("/");
                HashSet<String> operationSet = new HashSet<>();
                operationSet.add("+");
                operationSet.add("-");
                operationSet.add("/");
                operationSet.add("*");
                //Проверка входит ли символ в множество
                for (int i = 0; i < expression.length(); i++) {
                    if (!(charSet.contains(("" + expression.charAt(i))))) {

                        System.out.println("Выражение содержит неподдерживаемые символы");
                        error++;
                    }
                }
                if (error > 0) {

                    break;
                }
                //Проверка введенных чисел на присутствие в диапазоне 1..10 или I..X
                if (!((roman_arabic(s1) >= 1) && (roman_arabic(s1) <= 10))) {

                    System.out.println("Введенное число " + s1 + " не присутсвует в диапазоне 1..10 или I..X");
                    break;
                }
                if ((!((roman_arabic(s2) >= 1) && (roman_arabic(s2) <= 10)))) {

                    System.out.println("Введенное число " + s2 + " не присутсвует в диапазоне 1..10 или I..X");
                    break;
                }
                //Проверка операции
                if (!(operationSet.contains(operation))) {
                    System.out.println("Операция " + operation + " не является математической");
                    break;
                }
                //Проверка на количество знаков операций в выражении
                int operationCount = 0;

                for (int i = 0; i < expression.length(); i++) {
                    if ((operationSet.contains(("" + expression.charAt(i))))) {
                        operationCount++;
                    }
                }
                if (operationCount != 1) {
                    System.out.println("Количество операций больше заданного условия");
                }

                //Вычисления для арабских цифр
                if (arabicCheck(s1) && arabicCheck(s2)) {
                    
                    System.out.print("Ответ ");
                    System.out.println(Operations(operation, Integer.parseInt(s1), Integer.parseInt(s2)));
                }
                
                //Вычисления для римских цифр
                else if (romanCheck(s1) && romanCheck(s2)) {

                    if ((Operations(operation, roman_arabic(s1), roman_arabic(s2))) > 0) {
                        
                        System.out.print("Ответ ");
                        System.out.println(arabic_roman(Operations(operation, roman_arabic(s1), roman_arabic(s2))));
                    } else {
                        
                        System.out.println("Римские числа многут быть только положительными и не равняться нулю");
                        break;
                    }
                } else {

                    System.out.println("Калькулятор не умеет работать с числами из разных систем счисления");
                    break;
                }
            }
        }
    }
}
