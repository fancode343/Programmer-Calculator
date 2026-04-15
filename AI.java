package Calculator;

import java.util.ArrayList;
import java.util.List;

public class AI{

    // -------------------------------------------------------------------------
    // MDAS – handles multiplication, division, modulo, then addition/subtraction
    // -------------------------------------------------------------------------
    public String MDAS(String expression) {
        Operator Operator = new Operator();
        if (expression == null || expression.trim().isEmpty()) {
            return "0";
        }

        List<String> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        int i = 0;
        boolean expectNumber = true;  // true at start or after an operator

        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (expectNumber && c == '-') {
                // Unary minus
                current.append('-');
                i++;
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                current.append(c);
                expectNumber = false;
            } else if (c == '+' || c == '-' || c == 'x' || c == '÷' || c == '%') {
                // Save previous number if any
                if (current.length() > 0) {
                    numbers.add(current.toString());
                    current.setLength(0);
                }
                operators.add(c);
                expectNumber = true;
            } else if (Character.isWhitespace(c)) {
                // ignore spaces
            } else {
                return "Invalid character: " + c;
            }
            i++;
        }

        // Don't forget the last number
        if (current.length() > 0) {
            numbers.add(current.toString());
        }

        // Safety check
        if (numbers.isEmpty()) {
            return "0";
        }
        if (numbers.size() != operators.size() + 1) {
            return "Parsing error: mismatched numbers and operators";
        }

        // Handle × ÷ % left-to-right
        i = 0;
        while (i < operators.size()) {
            char op = operators.get(i);
            if (op == 'x' || op == '÷' || op == '%') {
                String aStr = numbers.get(i);
                String bStr = numbers.get(i + 1);

                String result;
                try {
                    if (op == 'x') {
                        result = Operator.multiply(aStr, bStr);
                    } else if (op == '÷') {
                        result = Operator.divide(aStr, bStr);
                    } else {
                        result = Operator.modulo(aStr, bStr);
                    }
                } catch (Exception e) {
                    return "Error in " + op + " operation: " + e.getMessage();
                }

                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                // Do not increment i — re-evaluate same position
            } else {
                i++;
            }
        }

        // Handle + - left-to-right
        i = 0;
        while (i < operators.size()) {
            char op = operators.get(i);
            String aStr = numbers.get(i);
            String bStr = numbers.get(i + 1);

            String result;
            try {
                if (op == '+') {
                    result = Operator.add(aStr, bStr);
                } else {
                    result = Operator.subtract(aStr, bStr);
                }
            } catch (Exception e) {
                return "Error in " + op + " operation: " + e.getMessage();
            }

            numbers.set(i, result);
            numbers.remove(i + 1);
            operators.remove(i);
            // No increment — re-check
        }

        return numbers.get(0);
    }

    // -------------------------------------------------------------------------
    // PEMDAS entry point – adds implicit multiplication around parentheses
    // -------------------------------------------------------------------------
    public String PEMDAS(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "0";
        }

        // Check balanced parentheses
        int balance = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return "Invalid Parenthesis – too many closing";
        }
        if (balance != 0) return "Invalid Parenthesis – unbalanced";

        // Insert implicit multiplication
        StringBuilder edited = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                // number or ) before ( → insert ×
                if (i > 0) {
                    char prev = input.charAt(i - 1);
                    if (Character.isDigit(prev) || prev == ')' || prev == '.') {
                        edited.append('x');
                    }
                }
                edited.append(c);
            } else if (c == ')') {
                edited.append(c);
                // number or ( after ) → insert ×
                if (i < input.length() - 1) {
                    char next = input.charAt(i + 1);
                    if (Character.isDigit(next) || next == '(' || next == '.') {
                        edited.append('x');
                    }
                }
            } else {
                edited.append(c);
            }
        }

        String finalExpr = edited.toString();
        // System.out.println("After implicit × insertion: " + finalExpr);

        return solveWithParentheses(finalExpr);
    }

    // -------------------------------------------------------------------------
    // Recursive parentheses solver
    // -------------------------------------------------------------------------
    private String solveWithParentheses(String expr) {
        if (!expr.contains("(")) {
            // System.out.println("No parens → MDAS: " + expr);
            return MDAS(expr);
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < expr.length()) {
            char c = expr.charAt(i);

            if (c == '(') {
                int count = 1;
                int start = i;
                i++;  // skip (

                while (i < expr.length() && count > 0) {
                    if (expr.charAt(i) == '(') count++;
                    if (expr.charAt(i) == ')') count--;
                    i++;
                }

                String inside = expr.substring(start + 1, i - 1);
                String solvedInside = solveWithParentheses(inside);

                // Add implicit × before the solved part if needed
                if (result.length() > 0) {
                    char prev = result.charAt(result.length() - 1);
                    if (Character.isDigit(prev) || prev == ')' || prev == '.') {
                        result.append('x');
                    }
                }

                result.append(solvedInside);

                // Add implicit × after if next is number or (
                if (i < expr.length()) {
                    char next = expr.charAt(i);
                    if (Character.isDigit(next) || next == '(' || next == '.') {
                        result.append('x');
                    }
                }
            } else {
                result.append(c);
                i++;
            }
        }

        String finalStr = result.toString();
        // System.out.println("After parentheses solved: " + finalStr);
        return MDAS(finalStr);
    }
}