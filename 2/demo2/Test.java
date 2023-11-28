package demo2;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        athletes athletes = new athletes();
        athletes.setAge(18);
        athletes.setName("陈");
        athletes.learnEnglish();
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < stack.peek()) {
                stack.add(prices[i]);
            } else {
                res = Math.max(res, prices[i] - stack.peek());
            }
        }
        return res;
    }

    public int maxProfit1(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else if (prices[i] - min_price > maxprofit) {
                maxprofit = prices[i] - min_price;
            }
        }
        return maxprofit;
    }
}
