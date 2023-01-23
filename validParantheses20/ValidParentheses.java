package validParantheses20;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        //test case
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //we use a stack for solving the problem
        Stack<Character> stack = new Stack<>();

        //whenever we meet an opening character, we add the closing ourselves
        //for the next character, we check the last element of stack with what we put previously
        //after all we should check whether our stack is empty or not
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar=='(') {
                stack.push(')');
            }
            else if (currentChar=='[') {
                stack.push(']');
            }
            else if (currentChar=='{') {
                stack.push('}');
            }
            else if (stack.isEmpty() || stack.pop()!=currentChar) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
