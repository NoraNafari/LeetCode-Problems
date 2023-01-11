package minStack155;

import java.util.Stack;

public class MinStackProblem {

    public static void main(String[] args) {
    //test case
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
         // return -3
        System.out.println(minStack.getMin());
        minStack.pop();
            // return 0
        System.out.println(minStack.top());
         // return -2
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    private int minimum = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }


    public void push(int val) {
        //here we can keep track of the next minimum value
        //if the value is smaller than the previous minimum, we keep the previous minimum
        // in the stack in case we wanted to pop.
        //It's a kind of sort to me, in which you can always keep track of the next minimum in the stack
        if (val<minimum) {
            stack.push(minimum);
            minimum = val;
        }
        stack.push(val);
    }

    public void pop() {
        Integer popped = stack.pop();
        //if the popped element is equal to the minimum, we get the next min
        if (minimum==popped) {
            minimum = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }
}
