import java.util.Scanner;

class Stack {
    int top;
    int capacity;
    char[] charArray;
    int[] intArray;

    Stack(int size) {
        capacity = size;
        top = -1;
        charArray = new char[size];
        intArray = new int[size];
    }

    void pushChar(char item) {
        charArray[++top] = item;
    }

    char popChar() {
        return charArray[top--];
    }

    char peekChar() {
        return charArray[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    void pushInt(int item) {
        intArray[++top] = item;
    }

    int popInt() {
        return intArray[top--];
    }
}

public class Program {
    static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }

    static String infixToPostfix(String exp) {
        Stack stack = new Stack(exp.length());
        String result = "";

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.pushChar(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peekChar() != '(')
                    result += stack.popChar();
                stack.popChar();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peekChar()))
                    result += stack.popChar();
                stack.pushChar(c);
            }
        }

        while (!stack.isEmpty())
            result += stack.popChar();

        return result;
    }

    static int evaluatePostfix(String exp) {
        Stack stack = new Stack(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.pushInt(c - '0');
            } else {
                int val2 = stack.popInt();
                int val1 = stack.popInt();
                int result = 0;

                if (c == '+')
                    result = val1 + val2;
                else if (c == '-')
                    result = val1 - val2;
                else if (c == '*')
                    result = val1 * val2;
                else if (c == '/')
                    result = val1 / val2;

                stack.pushInt(result);
            }
        }

        return stack.popInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        String input = sc.nextLine();

        input = input.replaceAll(" ", "");

        String postfix = infixToPostfix(input);
        int result = evaluatePostfix(postfix);

        System.out.println("Postfix expression is: " + postfix);
        System.out.println("Result of the evaluation: " + result);
    }
}
