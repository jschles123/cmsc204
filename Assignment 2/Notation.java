import java.util.ArrayList;

public class Notation {

    /**
     * Converts a infix expression to postfix
     * @param str original infix expression
     * @return new postfix expression
     * @throws InvalidNotationFormatException
     */

    public static String convertPostfixToInfix(String str) throws InvalidNotationFormatException{
        MyStack<String> stack = new MyStack();

        try {
            for (int i = 0; i < str.length(); i++) {
                String curr = str.substring(i, i + 1);
                System.out.println(curr + " curr");
                System.out.println(stack + " stack");
                if (curr.equals(" ")) {

                } else if (curr.matches("[0-9]")) {
                    stack.push(curr);
                } else if (curr.matches("[+-/*]")) {
                    String secondNumber = stack.pop();
                    String firstNumber = stack.pop();
                    stack.push("(" + firstNumber + curr + secondNumber + ")");
                }
            }
        }catch(Exception e){
            throw new InvalidNotationFormatException();
        }
        return stack.toString();
    }

    /**
     * Converts postfix expression to infix
     * @param str original postfix expression
     * @return new infix expression
     * @throws InvalidNotationFormatException
     */

    public static String convertInfixToPostfix(String str) throws InvalidNotationFormatException{
        MyStack<String> stack = new MyStack();
        MyQueue<String> queue = new MyQueue();

        try {
            for (int i = 0; i < str.length(); i++) {
                System.out.println("Stack on i = " + i + "     :" + stack.toString());
                System.out.println("Queue on i = " + i + "     :" + queue.toString());

                String curr = str.substring(i, i + 1);
                System.out.println(str.substring(i, i + 1));
                if (curr.equals(" ")) {

                } else if (curr.equals("(")) {
                    stack.push(curr);

                } else if (curr.matches("[0-9]")) {
                    System.out.println("here");
                    queue.enqueue(curr);



                } else if (curr.matches("[*/]")) {
                    stack.push(curr);



                } else if (curr.matches("[+-]")) {
                    System.out.println("matches + or -");
                    while (true) {
                        if (stack.top().matches("[/*]")) {
                            queue.enqueue(stack.pop());
                        } else {
                            System.out.println("here");
                            stack.push(curr);
                            break;
                        }
                    }
                } else if (curr.matches("\\)")) {
                    System.out.println("here");
                    System.out.println(curr + " curr");
                    System.out.println(stack.top() + " top");
                    System.out.println(stack.top().matches("\\("));
                    while (true) {
                        if (stack.top().matches("\\(")) {
                            System.out.println("here1");
                            stack.pop();
                            break;
                        } else {
                            queue.enqueue(stack.pop());
                            System.out.println("here2");
                        }
                    }

                }


            }
        }catch(Exception e){
            throw new InvalidNotationFormatException();
        }
        return queue.toString();
    }



    public static int evaluatePostfixExpression(String str) throws InvalidNotationFormatException{
        MyStack<Integer> stack = new MyStack();
        MyQueue<Integer> queue = new MyQueue();
        int val = -1;
        try {
            for (int i = 0; i < str.length(); i++) {
                String curr = str.substring(i, i + 1);
                System.out.println(curr + " curr");

                if (curr.equals(" ")) {
                    continue;
                } else if (curr.matches("[0-9]")) {
                    stack.push(Integer.parseInt(curr));
                }else if (curr.matches("[+-/*]")) {
                    stack.push(doOpearation(stack.pop(),stack.pop(),curr));
                }
            }
            val = stack.pop();
        }catch(Exception e){
            throw new InvalidNotationFormatException();
        }
        return val;
    }

    private boolean isValid(String str) {
        return true;
    }

    private static int doOpearation(int secondNumber, int firstNumber, String operation) throws InvalidNotationFormatException{
        System.out.println(operation);
        switch (operation) {
            case"+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "/":
                return firstNumber / secondNumber;
            case "*":
                System.out.println("here");
                return firstNumber * secondNumber;
        }
        return -1;
    }


}
