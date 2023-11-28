import java.util.Stack;
import java.util.regex.Pattern;


public class 逆波兰表达式求值 {
    class Solution {
        public static boolean isNumeric(String str) {
            for (int i = str.length(); --i >= 0; ) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public int evalRPN(String[] tokens) {
            Stack<Integer> s1 = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (isNumeric(tokens[i])) {
                    s1.push(Integer.parseInt(tokens[i]));
                } else {
                    if (tokens[i].equals("+")) {
                        s1.push(s1.pop() + s1.pop());
                    } else if (tokens[i].equals("-")) {
                        int a = s1.pop();
                        int b = s1.pop();
                        s1.push(b - a);
                    } else if (tokens[i].equals("*")) {
                        s1.push(s1.pop() * s1.pop());
                    } else if (tokens[i].equals("/")) {
                        int a = s1.pop();
                        int b = s1.pop();
                        s1.push(b / a);
                    }
                }
            }
            return s1.pop();
        }

        class Solution1 {
            public int evalRPN(String[] tokens) {
                Stack<Integer> sta = new Stack<>();
                int sum = 0;
                for (int i = 0; i < tokens.length; i++) {
                    if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                        sta.push(Integer.valueOf(tokens[i]));
                    } else {
                        if (tokens[i].equals("+")) {
                            sta.push(sta.pop() + sta.pop());
                        } else if (tokens[i].equals("-")) {
                            int a = sta.pop();
                            int b = sta.pop();
                            sta.push(b - a);
                        } else if (tokens[i].equals("*")) {
                            sta.push(sta.pop() * sta.pop());
                        } else if (tokens[i].equals("/")) {
                            int a = sta.pop();
                            int b = sta.pop();
                            sta.push(b / a);
                        }
                    }
                }
                return sta.pop();
            }
        }

        public static void main(String[] args) {
            Pattern pattern = Pattern.compile("[0-9]*");
        }
    }
}
