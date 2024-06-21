import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluator {

    public static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern
                .compile(
                        "e|sqrt|abs|sin|cos|tan|arcsin|arccos|arctan|!|log|ln|e\\^|\\^|π|%|\\d+\\.\\d+|\\d+|[()+\\-*/]");
        Matcher matcher = pattern.matcher(expression);

        boolean previousIsOperator = true;

        while (matcher.find()) {
            String token = matcher.group();
            if (token.equals("-") && previousIsOperator) {
                if (matcher.find()) {
                    tokens.add("-" + matcher.group());
                }
            } else {
                tokens.add(token);
                previousIsOperator = token.matches("[+\\-*/(]");
            }
        }
        return tokens;
    }

    public static int precedence(String op) {
        switch (op) {
            case "sin":
            case "cos":
            case "tan":
            case "arcsin":
            case "arccos":
            case "arctan":
            case "!":
            case "log":
            case "ln":
            case "e^":
            case "^":
            case "abs":
            case "sqrt":
            case "e":
                return 3;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            default:
                return 0;
        }
    }

    public static List<String> infixToPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+\\.\\d+|-?\\d+|π|e")) {
                output.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else if (token.matches("sqrt|abs|sin|cos|tan|arcsin|arccos|arctan|!|log|ln|e\\^|\\^")) {
                stack.push(token);
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    public static String evaluatePostfix(List<String> postfixTokens) {
        Stack<Double> stack = new Stack<>();


        for (String token : postfixTokens) {
            if (token.matches("-?\\d+\\.\\d+|-?\\d+")) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("π")) {
                stack.push(Math.PI);
            } else if (token.equals("e")) {
                stack.push(Math.E);
            } else if (token.matches("sqrt|abs|sin|cos|tan|arcsin|arccos|arctan")) {
                double value = stack.pop();
                switch (token) {
                    case "sin":
                        stack.push(Math.sin(Math.toRadians(value)));
                        break;
                    case "cos":
                        stack.push(Math.cos(Math.toRadians(value)));
                        break;
                    case "tan":
                        stack.push(Math.tan(Math.toRadians(value)));
                        break;
                    case "arcsin":
                        stack.push(Math.toDegrees(Math.asin(value)));
                        break;
                    case "arccos":
                        stack.push(Math.toDegrees(Math.acos(value)));
                        break;
                    case "arctan":
                        stack.push(Math.toDegrees(Math.atan(value)));
                        break;
                    case "abs":
                        stack.push(Math.abs(value));
                        break;
                    case "sqrt":
                        if (value < 0) {
                            return "Error: sqrt of negative number";
                        }
                        stack.push(Math.sqrt(value));
                        break;
                }
            } else if (token.matches("!|log|ln|e\\^|\\^")) {
                double value = stack.pop();
                switch (token) {
                    case "!":
                        if (value < 0 || value != Math.floor(value)) {
                            return "Error: factorial of negative or non-integer";
                        }
                        stack.push(factorial(value));
                        break;
                    case "log":
                        if(value < 0){
                            return "Error";
                        }
                        stack.push(Math.log10(value));
                        break;
                    case "ln":
                        stack.push(Math.log(value));
                        break;
                    case "e^":
                        stack.push(Math.exp(value));
                        break;
                    case "^":
                        double exponent = stack.pop();
                        stack.push(Math.pow(exponent, value));
                        break;
                }
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0) {
                            return "Error: division by zero";
                        }
                        stack.push(a / b);
                        break;
                    case "%":
                        stack.push(a % b);
                        break;
                }
            }
        }

        return Double.toString(stack.pop());
    }

    public static double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static String evaluate(String expression) {
        List<String> tokens = tokenize(expression);
        return evaluatePostfix(infixToPostfix(tokens));
    }

    
}
