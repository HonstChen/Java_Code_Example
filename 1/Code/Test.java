import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        System.out.println("年龄为:" + 23 + 1);
    }

    class MaxQueue {
        Deque<Integer> deque1, deque2;

        public MaxQueue() {
            deque1 = new ArrayDeque<>();
            deque2 = new ArrayDeque<>();
            //2作为非严格单调递减的队列，其队首为当前的最大的值即可
        }

        public int max_value() {
            if (!deque2.isEmpty()) {
                return deque2.peekFirst();
            } else return -1;
        }

        public void push_back(int value) {
            deque1.add(value);
            while (!deque2.isEmpty() && value > deque2.peekLast()) {
                deque2.pollLast();
            }
            deque2.offerLast(value);
        }

        public int pop_front() {
            if (!deque1.isEmpty()) {
                int res = deque1.pollFirst();
                if (!deque2.isEmpty() && deque2.peekFirst() == res) {
                    deque2.pollFirst();
                }
                return res;
            } else return -1;
        }
    }
}

class Solution {
    static int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;
        int excess = node.val - 1;
        int leftexcess = dfs(node.left);
        int rightexcess = dfs(node.right);
        if (leftexcess > 0) {
            result += leftexcess;
        }
        if (rightexcess > 0) {
            result += rightexcess;
        }
        return leftexcess + result + rightexcess;
    }
}
class Solution1 {
    static int result = 0;

    public int distributeCoins(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode node) {
        // 递归的终止条件：如果节点为空，返回硬币过剩数量为0
        if (node == null) return 0;

        // 计算左子树和右子树的硬币过剩数量
        int leftexcess = dfs(node.left);
        int rightexcess = dfs(node.right);

        // 计算当前节点的硬币过剩数量
        int excess = node.val + leftexcess + rightexcess - 1;

        // 计算移动硬币的次数，将左子树和右子树的硬币过剩数量取绝对值并累加到结果中
        result += Math.abs(leftexcess) + Math.abs(rightexcess);

        // 返回当前节点的硬币过剩数量
        return excess;
    }
}