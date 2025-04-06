/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lr14model_soft;

/**
 *
 * @author yigna
 */

/*
import java.util.Scanner;

public class LR14model_soft {


    public static void main(String[] args) {
        double[] xi = new double[15];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 15 чисел (положительных и отрицательных, вещественных):\n p.s. при вводе букв в массив, они удаляться \nоднако `ю` и `б` заменятся на точку ");

         for (int i = 0; i < xi.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Элемент " + (i + 1) + ": ");
                String input = scanner.nextLine();

                // Сначала заменяем "ю" и "б" на точку
                input = input.replaceAll("[ю]", ".");
                input = input.replaceAll("[б]", ".");

                // Теперь удаляем все символы, кроме цифр, точки, запятой и минуса
                input = input.replaceAll("[^\\d.\\-,]", "");

                // Заменяем "," на "." (если осталась)
                input = input.replace(",", ".");

                try {
                    xi[i] = Double.parseDouble(input);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                }
            }
        }

        // Выводим массив (для проверки)
        System.out.println("Массив Xi:");
        for (double value : xi) {
            System.out.print("(" + value + ") "); // Добавляем круглые скобки
        }
        System.out.println();

        // Вычисляем среднее арифметическое положительных и отрицательных элементов
        double r1 = calculateAverage(xi, true);  // true - для положительных
        double r2 = calculateAverage(xi, false); // false - для отрицательных

        System.out.println("Среднее арифметическое положительных элементов (R1): " + r1);
        System.out.println("Среднее арифметическое отрицательных элементов (R2): " + r2);

        // Определяем, какое из значений больше по абсолютной величине
        if (Math.abs(r1) > Math.abs(r2)) {
            System.out.println("Абсолютное значение R1 больше, чем абсолютное значение R2.");
        } else if (Math.abs(r1) < Math.abs(r2)) {
            System.out.println("Абсолютное значение R2 больше, чем абсолютное значение R1.");
        } else {
            System.out.println("Абсолютные значения R1 и R2 равны.");
        }

        scanner.close(); // Закрываем Scanner
    }

    // Метод для вычисления среднего арифметического положительных или отрицательных элементов
    public static double calculateAverage(double[] array, boolean positive) {
        double sum = 0;
        int count = 0;

        for (double value : array) {
            if (positive && value > 0) {
                sum += value;
                count++;
            } else if (!positive && value < 0) {
                sum += value;
                count++;
            }
        }

        if (count == 0) {
            return 0; // Чтобы избежать деления на ноль, если нет элементов нужного знака
        }

        return sum / count;
    }
}
 */
import java.util.Scanner;
import java.lang.Math;

public class LR14model_soft {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите номер задания для выполнения:");
            System.out.println("1. Решение квадратного уравнения");
            System.out.println("2. Определение вида треугольника");
            System.out.println("3. Определение вида четырехугольника (упрощенная версия)");
            System.out.println("4. Автоматический тест программы"); // Новый пункт
            System.out.println("0. Выход");

            System.out.print("Введите номер задания: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1; // Значение по умолчанию для некорректного ввода
            }

            switch (choice) {
                case 1:
                    solveQuadraticEquationMenu(scanner);
                    break;
                case 2:
                    determineTriangleTypeMenu(scanner);
                    break;
                case 3:
                    determineQuadrilateralType(scanner);
                    break;
                case 4:
                    runAutomatedTests(); // Вызов метода для запуска тестов
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    if (choice != -1) {
                        System.out.println("инвалид синтаксис @_@\\nНекорректный ввод . Пожалуйста, выберите задание из списка.");
                    } else {
                        System.out.println("инвалид синтаксис @_@\\nНекорректный ввод . Пожалуйста, введите  число.");
                    }
            }
        }
    }

    // Метод для запуска автоматизированных тестов
    public static void runAutomatedTests() {
        System.out.println("\nЗапуск автоматизированных тестов...");

        // Тесты для квадратного уравнения (Задание 1)
        System.out.println("\nТест задания №1: Решение квадратного уравнения:");
        testQuadraticEquation(1, -5, 6, "Уравнение имеет два корня: x1 = 3.0, x2 = 2.0");
        testQuadraticEquation(1, -4, 4, "Уравнение имеет один корень: x = 2.0");
        testQuadraticEquation(1, 2, 5, "Уравнение не имеет вещественных корней.");

        // Тесты для определения типа треугольника (Задание 2)
        System.out.println("\nТест задания №2: Определение типа треугольника:");
        testTriangleType(3, 4, 5, "Треугольник прямоугольный.");
        testTriangleType(5, 5, 5, "Треугольник равносторонний.");
        testTriangleType(3, 4, 10, "Треугольник не существует."); // Некорректный треугольник

         // Тесты для определения типа четырехугольника (Задание 3)
        System.out.println("\nТест задания №3: Определение типа четырехугольника:");
        System.out.println("\nТестирование getValidDoubleInput:");
        testValidDoubleInput("123", 123.0);
        testValidDoubleInput("123.45", 123.45);
        testValidDoubleInput("  123.45  ", 123.45); // Проверка пробелов
        testValidDoubleInput("ю", 0.0); // Проверка замены "ю"
        testValidDoubleInput("123,45", 123.45); // Проверка замены запятой
        testValidDoubleInput("-123.45", -123.45); // Проверка отрицательных чисел
        testValidDoubleInput("abc123.45def", 123.45); // Проверка букв в начале и конце
        testValidDoubleInput("123.45abc", 123.45); // Проверка букв в конце
        testValidDoubleInput("abc123.45", 123.45); // Проверка букв в начале
        testValidDoubleInput("1.2.3", 1.2); // Проверка нескольких точек
        testValidDoubleInput("   -  123.45  ", -123.45); // Проверка пробелов и минуса
        testValidDoubleInput("1000-7", 1000.0); // Проверка удаления всего кроме цифр точки запятой и минуса
        testValidDoubleInput("1000+7", 1000.0); // Проверка удаления всего кроме цифр точки запятой и минуса
        testValidDoubleInput("12,,34", 12.0); // Проверка замены двойной запятой (ожидаем 12.0, так как остальное отбрасывается)
        testValidDoubleInput("1,,2,,3", 1.0); // Проверка нескольких двойных запятых
        testValidDoubleInput(",,123", 0.0); // Проверка двойной запятой в начале
        testValidDoubleInput("123,,", 123.0); // Проверка двойной запятой в конце
        testValidDoubleInput("12,,3.4", 12.0); // Проверка с точкой и двойной запятой
        testValidDoubleInput("12,3,4", 12.0); // Дополнительная проверка нескольких запятых
        testValidDoubleInput("1,2,3,4", 1.0); // Дополнительная проверка нескольких запятых
        
        testValidDoubleInput("1б5", 1.5);  // "б" заменяется на ".", остается "1.5"
        testValidDoubleInput("1ю5", 1.5);  // "ю" заменяется на ".", остается "1.5"
        testValidDoubleInput("1бб5", 1.5); // "бб" заменяется на ".", остается "1.5"
        testValidDoubleInput("1юю5", 1.5); // "юю" заменяется на ".", остается "1.5"
        testValidDoubleInput("1б.5", 1.5); // "б" заменяется на ".", остается "1..5" -> "1.0"
        testValidDoubleInput("1ю.5", 1.5); // "ю" заменяется на ".", остается "1..5" -> "1.0"
        testValidDoubleInput("1,б5", 1.5); // "," и "б" заменяются на ".", остается "1..5" -> "1.0"
        testValidDoubleInput("1,ю5", 1.5); // "," и "ю" заменяются на ".", остается "1..5" -> "1.0"
        testValidDoubleInput("1б5abc", 1.5);  // "б" заменяется на ".", остается "1.5abc" -> "1.0"
        testValidDoubleInput("abc1ю5def", 1.5);  // "ю" заменяется на ".", остается "abc1.5def" -> "1.0"
        testValidDoubleInput("1бб5", 1.5); // ""бб" заменяется на ".", остается "1.5"
        testValidDoubleInput("1юю5", 1.5); // ""юю" заменяется на ".", остается "1.5"
        
        
        System.out.println("\nАвтоматизированные тесты завершены.");
    }

    // Вспомогательный метод для тестирования квадратного уравнения
    public static void testQuadraticEquation(double a, double b, double c, String expected) {
        try {
            String result = solveQuadraticEquation(a, b, c); // Вызов метода бизнес-логики
            if (result.equals(expected)) {
                System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " пройден.");
            } else {
                System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " не пройден. Ожидалось: " + expected + ", получено: " + result);
            }
        } catch (Exception e) {
            System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " вызвал исключение: " + e.getMessage());
        }
    }

    // Вспомогательный метод для тестирования типа треугольника
    public static void testTriangleType(double a, double b, double c, String expected) {
        try {
            String result = determineTriangleType(a, b, c);
            if (result.equals(expected)) {
                System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " пройден.");
            } else {
                System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " не пройден. Ожидалось: " + expected + ", получено: " + result);
            }
        } catch (Exception e) {
            System.out.println("Тест для a=" + a + ", b=" + b + ", c=" + c + " вызвал исключение: " + e.getMessage());
        }
    }

    // Вспомогательный метод для тестирования getValidDoubleInput
    public static void testValidDoubleInput(String input, double expected) {
        try {
            Scanner testScanner = new Scanner(input);
            double result = getValidDoubleInput(testScanner, "Тест: "); // Изменили prompt

            if (Double.compare(result, expected) == 0) {
                System.out.println("Тест для ввода \"" + input + "\" пройден. Ожидалось: " + expected + ", получено: " + result);
            } else {
                System.out.println("Тест для ввода \"" + input + "\" не пройден. Ожидалось: " + expected + ", получено: " + result);
            }
        } catch (Exception e) {
            System.out.println("Тест для ввода \"" + input + "\" вызвал исключение: " + e.getMessage());
        }
    }

    public static String determineTriangleType(double sideA, double sideB, double sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            return "Треугольник не существует.";
        } else {
            if (sideA == sideB && sideB == sideC) {
                return "Треугольник равносторонний.";
            } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
                return "Треугольник равнобедренный.";
            } else if (sideA * sideA + sideB * sideB == sideC * sideC ||
                    sideA * sideA + sideC * sideC == sideB * sideB ||
                    sideB * sideB + sideC * sideC == sideA * sideA) {
                return "Треугольник прямоугольный.";
            } else {
                return "Треугольник разносторонний.";
            }
        }
    }

    // Метод для решения квадратного уравнения (бизнес-логика, возвращает строку)
    public static String solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return "Уравнение имеет два корня: x1 = " + x1 + ", x2 = " + x2;
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return "Уравнение имеет один корень: x = " + x;
        } else {
            return "Уравнение не имеет вещественных корней.";
        }
    }

    //метод для определения типа четырехугольника (Упрощенная версия - только прямоугольник и не прямоугольник)
    public static void determineQuadrilateralType(Scanner scanner) {
        System.out.println("Задача 3: Определение вида четырехугольника (Упрощенная версия)");
        System.out.println("Введите координаты вершин четырехугольника (x1 y1 x2 y2 x3 y3 x4 y4):");
        double x1 = getValidDoubleInput(scanner, "Введите координату x1: ");
        double y1 = getValidDoubleInput(scanner, "Введите координату y1: ");
        double x2 = getValidDoubleInput(scanner, "Введите координату x2: ");
        double y2 = getValidDoubleInput(scanner, "Введите координату y2: ");
        double x3 = getValidDoubleInput(scanner, "Введите координату x3: ");
        double y3 = getValidDoubleInput(scanner, "Введите координату y3: ");
        double x4 = getValidDoubleInput(scanner, "Введите координату x4: ");
        double y4 = getValidDoubleInput(scanner, "Введите координату y4: ");

        // Вычисляем длины сторон
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        double side4 = Math.sqrt(Math.pow(x1 - x4, 2) + Math.pow(y1 - y4, 2));

        // Проверяем, является ли четырехугольник прямоугольником
        boolean isRectangle = (side1 == side3 && side2 == side4);

        if (isRectangle) {
            System.out.println("Четырехугольник является прямоугольником.");
        } else {
            System.out.println("Четырехугольник не является прямоугольником.");
        }
        System.out.println("Исходные данные \n" + "x1= " + x1 + ", y1= " + y1 + ", x2= " + x2 + ", x3= " + x3 + ", y3= " + y3 + ", x4= " + x4 + ", y4= " + y4);

        System.out.println("Задача 3 решена.");
    }

    // Метод для получения корректного вещественного числа от пользователя
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            // Заменяем "ю" и "б" на точку
            input = input.replaceAll("[ю]", ".");
            input = input.replaceAll("[б]", ".");
            System.out.println("После замены ю и б: " + input); // Отладочное сообщение
            // Теперь удаляем все символы, кроме цифр, точки, запятой и минуса
            input = input.replaceAll("[^\\d.\\-,]", "");
            
            // Заменяем "," на "." (если осталась)
            input = input.replace(",", ".");
            System.out.println("После замены запятой: " + input); // Отладочное сообщение
            input = input.replace(",,", ".");
            System.out.println("После замены двойной запятой: " + input); // Отладочное сообщение
            input = input.replace("..", ".");
            System.out.println("После замены двойной точки: " + input); // Отладочное сообщение

            try {
                value = Double.parseDouble(input);
                System.out.println("Успешный парсинг: " + value); // Отладочное сообщение
                validInput = true;
            } catch (NumberFormatException e) {
               System.out.println("NumberFormatException: " + e.getMessage()); // Отладочное сообщение
               System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            }
        }
        return value;
    }

    //Метод для  меню выбора квадратного уравнения
    public static void solveQuadraticEquationMenu(Scanner scanner) {
        System.out.println("Задача 1: Решение квадратного уравнения ax^2 + bx + c = 0");
        double a = getValidDoubleInput(scanner, "Введите коэффициент a: ");
        double b = getValidDoubleInput(scanner, "Введите коэффициент b: ");
        double c = getValidDoubleInput(scanner, "Введите коэффициент c: ");

        String result = solveQuadraticEquation(a, b, c);  //Вызов метода с тремя даблами

        System.out.println(result);
        System.out.println("Исходные данные \n" + "a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("Задача 1 решена.\n");
    }

    //Метод для меню выбора типа треугольника
    public static void determineTriangleTypeMenu(Scanner scanner) {
        System.out.println("Задача 2: Определение вида треугольника");
        double sideA = getValidDoubleInput(scanner, "Введите длину стороны a: ");
        double sideB = getValidDoubleInput(scanner, "Введите длину стороны b: ");
        double sideC = getValidDoubleInput(scanner, "Введите длину стороны c: ");

        String result = determineTriangleType(sideA, sideB, sideC);

        System.out.println(result);
        System.out.println("Исходные данные \n" + "a = " + sideA + ", b = " + sideB + ", c = " + sideC);

        System.out.println("Задача 2 решена.\n");
    }
}