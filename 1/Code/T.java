import java.util.Map;
import java.util.Stack;

public class T {
    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void appendTail(int value) {
            this.s1.push(value);
        }

        public int deleteHead() {
            if (this.s1.isEmpty() && this.s2.isEmpty()) {
                return -1; // 队列为空，返回特定值
            }

            if (this.s2.isEmpty()) {
                while (!this.s1.isEmpty()) {
                    this.s2.push(this.s1.pop());
                }
            }

            return this.s2.pop();
        }
    }

    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> A, B;

        public MinStack() {
            A = new Stack<>();
            //数据栈
            //辅助栈，用来协助返回min值,B的栈顶存储当前的最小值
            B = new Stack<>();
        }

        public void push(int x) {
            A.push(x);
            if (B.isEmpty()) {
                B.push(x);
            } else if (x <= B.peek()) {
                B.push(x);
            }
        }

        public void pop() {
            if (!A.isEmpty()) {
                int temp = A.pop();
                if (B.peek() == temp) {
                    B.pop();
                }
            }
        }

        public int top() {
            if (!A.isEmpty())
                return A.peek();
            else return -1;
        }

        public int min() {
            if (!B.isEmpty())
                return B.peek();
            else return -1;
        }
    }
}

class MinStack {
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int val) {
        A.push(val);
        if (B.isEmpty()) {
            B.push(val);
        } else if (val <= B.peek()) {
            B.push(val);
        }
    }

    public void pop() {
        if (!A.isEmpty()) {
            int temp = A.pop();
            if (temp == B.peek()) {
                B.pop();
            }
        }
    }

    public int top() {
        if (!A.isEmpty())
            return A.peek();
        else return -1;
    }

    public int getMin() {
        if (!B.isEmpty())
            return B.peek();
        else return -1;
    }
}

class Solution2 {
    static int result = 0;

    public int distributeCoins(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftexcess = dfs(node.left);
        int rightexcess = dfs(node.right);
        result += Math.abs(leftexcess) + Math.abs(rightexcess);
        return node.val + leftexcess + rightexcess - 1;
    }
}