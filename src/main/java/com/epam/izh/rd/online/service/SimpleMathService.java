package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Math.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int i;
        int maxValue = values[0];
        for (i = 1; i < values.length; i++) {
            maxValue = Math.max(maxValue, values[i]);
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int i;
        int sum = 0;
        for (i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        int i;
        for (i = 0; i < values.length; i++) {
            if ((values[i] % 2) == 0) {
                evenList.add(values[i]);
            }
        }
        int[] evenArr = evenList.stream().mapToInt(Integer::intValue).toArray();
        return evenArr;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int i;
        int fact = 1;
        for (i = 1; i <= initialVal; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        int fibNumb = 0;
        if (number == 0) {
            fibNumb = 0;
        } else if (number == 1) {
            fibNumb = 1;
        } else {
            int fibPrev = 0;
            int fibNext = 1;
            int i;
            for (i = 2; i <= number; i++) {
                fibNumb = fibPrev + fibNext;
                fibPrev = fibNext;
                fibNext = fibNumb;
            }
        }
        return fibNumb;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        Arrays.sort(values);
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int counter = 0;
        int i;
        for (i = 2; i <= Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                counter++;
            }
        }
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        if (values.length == 0) {
            return values;
        }
        int[] reversedValues = new int[values.length];
        int indexOfLastMoving = values.length / 2;
        int i;
        for (i = 0; i <= indexOfLastMoving; i++) {
            reversedValues[i] = values[values.length - 1 - i];
            reversedValues[values.length - 1 - i] = values[i];
        }
        return reversedValues;
    }
}
