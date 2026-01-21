package com.assistant;

import java.util.regex.Pattern;

/**
 * Command to perform basic arithmetic calculations.
 * Demonstrates wrapper classes, autoboxing/unboxing, exception handling, and regex for parsing.
 */
public class CalculatorCommand extends Command {

    private static final Pattern CALC_PATTERN = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*(\\d+(?:\\.\\d+)?)");

    public CalculatorCommand() {
        super("calculate");
    }

    @Override
    public void execute(String[] args) throws Exception {
        String expression = String.join(" ", args);
        var matcher = CALC_PATTERN.matcher(expression);

        if (!matcher.matches()) {
            throw new InvalidCommandException("Usage: calculate <num1> <op> <num2> or calculate <num1><op><num2>");
        }

        try {
            Double num1 = Double.valueOf(matcher.group(1)); // Autoboxing
            String op = matcher.group(2);
            Double num2 = Double.valueOf(matcher.group(3)); // Autoboxing
            Double result = null;

            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new InvalidCommandException("Unsupported operator: " + op);
            }

            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid numbers provided");
        }
    }
}
