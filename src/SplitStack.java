import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

    public class SplitStack {
        public static void splitStack(Stack<Integer> stack) {
            Queue<Integer> queue = new LinkedList<>();


            while (!stack.isEmpty() && stack.peek() >= 0) {
                queue.add(stack.pop());
            }


            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }

            while (!stack.isEmpty()) {
                int num = stack.pop();
                if (num < 0) {
                    queue.add(num);
                } else {
                    stack.push(num);
                    break;
                }
            }

            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }

        public static void main(String[] args) {
            Stack<Integer> stack1 = new Stack<>();
            stack1.push(5);
            stack1.push(-5);
            stack1.push(67);
            stack1.push(-45);
            stack1.push(67);
            stack1.push(9);
            stack1.push(0);
            stack1.push(-42);
            stack1.push(56);
            stack1.push(-7);

            System.out.println("Original stack 1: " + stack1);
            splitStack(stack1);
            System.out.println("Modified stack 1: " + stack1);

            Stack<Integer> stack2 = new Stack<>();
            stack2.push(1);
            stack2.push(-2);
            stack2.push(-3);
            stack2.push(4);
            stack2.push(-5);
            stack2.push(6);
            stack2.push(-7);
            stack2.push(8);
            stack2.push(9);

            System.out.println("\nOriginal stack 2: " + stack2);
            splitStack(stack2);
            System.out.println("Modified stack 2: " + stack2);
        }
    }
}
