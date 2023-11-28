package LeetCode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int[] flag = new int[s.length()];
        //存储移动的方向
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                flag[i] = 1;
            } else flag[i] = -1;
        }
        for (int i = 0; i < d; i++) {
            //执行d次
            //判断发生碰撞的左右元素都应该改变其flag值
            //只有相邻元素会存在碰撞问题，也就是先记录上一个num的值，如果这个num发生碰撞，则改变
            nums[0] = nums[0] + flag[0];
            int temp = nums[0];
            for (int j = 1; j < flag.length; j++) {
                nums[j] = nums[j] + flag[j];
                if (nums[j] == temp) {
                    flag[j] = -flag[j];
                    flag[j - 1] = -flag[j - 1];
                } else {
                    temp = nums[j];
                }
            }
        }
        //记录路径距离
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                res += (Math.abs(nums[j] - nums[i])) % (int) (1e9 + 7);
                res %= (1e9 + 7);
            }
        }
        return (int) res;
    }

    public int sumDistance1(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] - d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += 1L * (pos[i] - pos[i - 1]) * i % (1e9 + 7) * (n - i) % (1e9 + 7);
            res %= (1e9 + 7);
        }
        return (int) res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> res = new ArrayList<>();
        Pattern compile = Pattern.compile("\\b\\w+\\b");
        Map<Integer, Integer> score = new HashMap<>();
        HashMap<String, Integer> hashMap_pos = new HashMap<>();
        HashMap<String, Integer> hashMap_neg = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (String s : positive_feedback) {
            hashMap_pos.put(s, 1);
        }
        for (String s : negative_feedback) {
            hashMap_neg.put(s, 1);
        }
        for (int i = 0; i < report.length; i++) {
            String text = report[i];
            int score_s = 0;
            Matcher matcher = compile.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                if (hashMap_pos.containsKey(word)) {
                    score_s += 3;
                } else if (hashMap_neg.containsKey(word)) {
                    score_s -= 1;
                }
            }
            score.put(student_id[i], score_s);
        }
        //根据score中的得分来进行学生id排序
        List<Map.Entry<Integer, Integer>> sortedStudents = new ArrayList<>(score.entrySet());
        sortedStudents.sort(((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue() - o1.getValue();
            }
        }));
        for (int i = 0; i < k && i < sortedStudents.size(); i++) {
            res.add(sortedStudents.get(i).getKey());
        }
        return res;
    }

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            StringBuilder sb = new StringBuilder();
            if (left == right) {
                //此时只剩一个元素
                sb.append(nums[left]);
                res += Integer.valueOf(sb.toString());
            } else {
                sb.append(nums[left]);
                sb.append(nums[right]);
                res += Integer.valueOf(sb.toString());
            }
            left++;
            right--;
        }
        return res;
    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '0')
                sb.deleteCharAt(i);
            else break;
        }
        return sb.toString();
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int res;
        return (res = money - prices[0] - prices[1]) < 0 ? money : res;
    }

    public int minimizeConcatenatedLength(String[] words) {
        int res = 0;
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            //存储头尾，存在可以连接的节点，则将其修改
            int size = words[i].length();
            char head = words[i].charAt(0);
            char tail = words[i].charAt(size - 1);
            if (hashMap.containsKey(tail)) {
                //存在和尾节点相连的头结点
                res = res + size - 1;
                hashMap.put(head, hashMap.get(tail));
                hashMap.remove(tail);
            } else if (hashMap.containsValue(head)) {
                res = res + size - 1;

            }
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
