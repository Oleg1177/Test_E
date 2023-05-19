import java.util.Scanner;
import java.util.Stack;

public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static double evaluateExpression(String expression) throws Exception {
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();

                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }

                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    double result = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(result);
                }

                if (operators.isEmpty() || operators.peek() != '(') {
                    throw new Exception("Неверное выражение: непарные скобки.");
                }

                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    double result = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(result);
                }

                operators.push(tokens[i]);
            } else {
                throw new Exception("Неверное выражение: недопустимый символ.");
            }
        }

        while (!operators.isEmpty()) {
            double result = applyOperator(operators.pop(), values.pop(), values.pop());
            values.push(result);
        }

        if (values.size() != 1) {
            throw new Exception("Неверное выражение: некорректное количество операторов и операндов.");
        }

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }

        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }

        return true;
    }

    public static double applyOperator(char operator, double operand2, double operand1) throws Exception {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new Exception("Неверное выражение: деление на ноль.");
                }
                return operand1 / operand2;
            default:
                throw new Exception("Неверное выражение: недопустимый оператор.");
        }
    }
}


