package ProgCal;

public class Operator {
    static String modulo(String a, String b) {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double equal = a1%b1;
    String stringEqual = Double.toString(equal);
        return stringEqual;
    }
    static String add(String a, String b) {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double equal = a1+b1;
    String stringEqual = Double.toString(equal);
        return stringEqual;
    }
    static String subtract(String a, String b) {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double equal = a1-b1;
    String stringEqual = Double.toString(equal);
        return stringEqual;
    }
    static String multiply(String a, String b) {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double equal = a1*b1;
    String stringEqual = Double.toString(equal);
        return stringEqual;
    }
    static String divide(String a, String b) {
    double a1 = Double.parseDouble(a);
    double b1 = Double.parseDouble(b);
    double equal = (a1)/b1;
    String stringEqual = Double.toString(equal);
        return stringEqual;
    }
}
