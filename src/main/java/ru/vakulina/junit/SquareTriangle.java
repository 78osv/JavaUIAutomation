package ru.vakulina.junit;

public class SquareTriangle {

    // метод для вычисление полупериметра
    public static double hp(double a, double b, double c) {
        return (a + b + c) / 2.0;
    }

    // метод для вычисления площади треугольника
    public static double square(double a, double b, double c) {
        double res = hp(a, b, c);
        return Math.sqrt(res * (res - a) * (res - b) * (res - c));
    }

}
