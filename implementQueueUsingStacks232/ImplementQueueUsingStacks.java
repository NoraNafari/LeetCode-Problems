package implementQueueUsingStacks232;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(4);
        queue.push(8);
        queue.push(2);
        //expected 1
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        //expected 4
        System.out.println(queue.peek());
    }
}

//We have to define two stacks one for pushing and one for popping
//We push into one and pop from the other
class MyQueue {
    Stack<Integer> pushStack = new Stack();
    Stack<Integer> popStack = new Stack();

    public MyQueue() {

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.empty()) {
            int size = pushStack.size();
            for (int i = 0; i < size; i++) {
                popStack.add(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.empty()) {
            int size = pushStack.size();
            for (int i = 0; i < size; i++) {
                popStack.add(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }
}