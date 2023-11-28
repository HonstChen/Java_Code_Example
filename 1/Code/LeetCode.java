import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.*;

public class LeetCode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        //两数求和
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = Reverse(l1);
            l2 = Reverse(l2);
            int record = 0;
            ListNode temp = new ListNode(0);
            ListNode res = temp;
            while (l1 != null && l2 != null) {
                int now = l1.val + l2.val + record;
                if (now >= 10) {
                    record = now / 10;
                    temp.next = new ListNode(now % 10);
                } else {
                    record = 0;
                    temp.next = new ListNode(now);
                }
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            l1 = l1 != null ? l1 : l2;
            while (l1 != null) {
                int now = l1.val + record;
                if (now >= 10) {
                    record = now / 10;
                    temp.next = new ListNode(now % 10);
                } else {
                    record = 0;
                    temp.next = new ListNode(now);
                }
                temp = temp.next;
                l1 = l1.next;
            }
            if (record != 0) {
                temp.next = new ListNode(record);
            }
            return res.next;
        }

        public ListNode Reverse(ListNode p) {
            //反转链表，返回反转后的值即可
            if (p.next == null) {
                return p;
                //一个直接反转就好
            }
            ListNode node = p;
            ListNode prev = null;//前驱节点
            ListNode next = new ListNode();
            while (node != null) {
                //连接节点
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }

        public ListNode reverseList(ListNode head) {
            ListNode node = head;
            ListNode prev = null;
            ListNode next = null;
            while (node != null) {
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }

        public ListNode deleteNode(ListNode head, int val) {
            ListNode newHead = new ListNode(-1, head);
            ListNode res = newHead;
            while (head != null) {
                if (head.val == val) {
                    newHead.next = head.next;
                    head = head.next;
                    continue;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return res.next;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode Lc, pc;
            Lc = pc = new ListNode(-1, l1);
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pc.next = l1;
                    pc = l1;
                    l1 = l1.next;
                } else {
                    pc.next = l2;
                    pc = l2;
                    l2 = l2.next;
                }
            }
            pc.next = l1 != null ? l1 : l2;
            return Lc.next;
        }

        public int removeElement(int[] nums, int val) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    nums[i--] = nums[--res];
                }
            }
            return res;
        }

        public int matrixSum(int[][] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                Arrays.sort(nums[i]);
            }
            for (int j = 0; j < nums[0].length; j++) {
                int max = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i][j] > max) {
                        max = nums[i][j];
                    }
                }
                res += max;
            }
            return res;
        }

        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            ArrayList<Integer> res = new ArrayList<>();
            int p1 = 0, p2 = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    res.add(nums2[p2]);
                    p1++;
                    p2++;
                } else {
                    if (nums1[p1] < nums2[p2]) {
                        p1++;
                    } else {
                        p2++;
                    }
                }
            }
            int[] result = res.stream().mapToInt(Integer::intValue).toArray();
            return result;
        }

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> que = new ArrayDeque<>();
            que.add(root);
            while (!que.isEmpty()) {
                int size = que.size();
                long sum = 0;
                int n = 0;
                while ((size--) != 0) {
                    TreeNode node = que.remove();
                    sum += node.val;
                    n++;
                    if (node.left != null)
                        que.add(node.left);
                    if (node.right != null)
                        que.add(node.right);
                }
                double r = (double) sum / n;
                res.add(r);
            }
            return res;
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> que = new ArrayDeque<>();
            que.add(root);
            while (!que.isEmpty()) {
                int size = que.size();
                while ((size--) != 0) {
                    TreeNode node = que.remove();
                    if (size == 0) res.add(node.val);
                    if (node.left != null) que.add(node.left);
                    if (node.right != null) que.add(node.right);
                }
            }
            return res;
        }

        public int countSeniors(String[] details) {
            int res = 0;
            for (int i = 0; i < details.length; i++) {
                int age = Character.getNumericValue(details[i].charAt(11)) * 10 + Character.getNumericValue(details[i].charAt(12));
                System.out.println(age);
                if (age > 60)
                    res++;
            }
            return res;
        }
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }

    public int minDistance(String word1, String word2) {
        int[][] temp = new int[26][2];
        int res = 0;
        for (int i = 0; i < word1.length(); i++) {
            temp[word1.charAt(i) - 'a'][1]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            temp[word2.charAt(i) - 'a'][1]--;
        }
        for (int i = 0; i < 26; i++) {
            res += Math.abs(temp[i][1]);
        }
        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while ((size--) != 0) {
                TreeNode node = que.remove();
                TreeNode T = node.left;
                node.left = node.right;
                node.right = T;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;

        boolean inside = compare(left.right, right.left);
        boolean outside = compare(left.left, right.right);
        boolean isSame = inside && outside;
        return isSame;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()) {
            TreeNode leftNode = que.poll();
            TreeNode RightNode = que.poll();
            if (leftNode == null && RightNode == null) {
                continue;
            }
            if ((leftNode == null || RightNode == null) || (leftNode.val != RightNode.val)) {
                return false;
            }
            que.offer(leftNode.left);
            que.offer(RightNode.right);
            que.offer(leftNode.right);
            que.offer(RightNode.left);
        }
        return true;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }

    public int[] shuffle(int[] nums) {
        //洗牌法
        if (nums.length == 0) {
            return null;
        }
        int[] res = nums.clone();   //复制一个数组来进行洗牌随机排序操作
        for (int i = 0; i < nums.length; i++) {
            int rand = (int) (Math.random() * (nums.length - i)) + i;
            int temp;
            temp = res[i];
            res[i] = res[rand];
            res[rand] = temp;
        }
        return res;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }

    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    ans++;
                    i += 2;
                } else if ((i - 1) >= 0 && hamsters.charAt(i - 1) == '.') {
                    ans++;
                } else return -1;
            }
        }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        return GetDepth(root);
    }

    public static int GetDepth(TreeNode root) {
        if (root == null) return 0;
        int left = GetDepth(root.left);
        int right = GetDepth(root.right);
        int depth = 1 + Math.max(left, right);
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    public int minDepth(TreeNode root) {
        return getDepth(root);
    }

    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + right;
        }
        if (root.left != null && root.right == null) {
            return 1 + left;
        }
        return 1 + Math.min(left, right);
    }

    public int minDepth1(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right == null) {
            return 1 + minDepth1(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth1(root.right);
        }
        return 1 + Math.min(minDepth1(root.left), minDepth1(root.right));
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            while (size-- != 0) {
                TreeNode node = que.remove();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }
        return depth;
    }

    public int threeSumClosest(int[] nums, int target) {
        int res;
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    //右侧指针移动
                    while (j < k && nums[k] == nums[--k]) ;
                }
                if (sum < target) {
                    while (j < k && nums[j] == nums[++j]) ;
                }
            }
        }
        return best;
    }

    public boolean wordPattern(String pattern, String s) {
        //首先处理字符串s，将每个单词提取出来,pattern中的一个词
        String[] help = getArrays(s);
        for (String i : help) {
            System.out.println(i);
        }
        if (pattern.length() != help.length)
            return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!hashMap.containsKey(pattern.charAt(i))) {
                if (hashMap.containsValue(help[i]))
                    return false;
                hashMap.put(pattern.charAt(i), help[i]);
            } else {
                //存在，比较键值
                if (!hashMap.get(pattern.charAt(i)).equals(help[i]))
                    return false;
            }
        }
        return true;
    }

    public static String[] getArrays(String s) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ') {
                //碰上空格，该单词结束
                res.add(temp.toString());
                temp.delete(0, temp.length());
            } else {
                temp.append(s.charAt(i));
            }
        }
        temp.append(s.charAt(s.length() - 1));
        res.add(temp.toString());
        return res.toArray(new String[res.size()]);
    }

    public int countNodes(TreeNode root) {
        //使用满二叉树的性质来进行求节点的个数
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null) {
            //求左子树的深度
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        return getDepth1(root) != -1 ? true : false;
    }

    public static int getDepth1(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth1(root.left);
        int rightDepth = getDepth1(root.right);
        if (leftDepth == -1) {
            return -1;
        }
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : 1 + Math.max(leftDepth, rightDepth);
    }

    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 0; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }

    public int alternateDigitSum(int n) {
        int temp = n, flag = 1, res = 0;
        while (temp != 0) {
            temp /= 10;
            flag = -flag;
        }
        while (n != 0) {
            res += (n % 10) * flag;
            flag = -flag;
            n /= 10;
        }
        return res;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int index = 0;
        if (m * n != original.length) return new int[0][0];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        return res;
    }

    class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; ; x++) {
            if (customfunction.f(x, 1) > z)
                break;
            for (int y = 1; ; ) {
                if (customfunction.f(x, y) < z)
                    y++;
                else if (customfunction.f(x, y) == z) {
                    res.add(Arrays.asList(x, y));
                    break;
                } else break;
            }
        }
        return res;
    }

    public boolean hasAlternatingBits(int n) {
        int flag = n & 1;
        n = n >> 1;
        while (n != 0) {
            if (flag == (n & 1)) {
                return false;
            } else flag = (n & 1);
            n = n >> 1;
        }
        return true;
    }

    public String customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); i++)
            val[order.charAt(i) - 'a'] = i;
        Character[] cs = new Character[s.length()];
        for (int i = 0; i < s.length(); i++)
            cs[i] = s.charAt(i);
        Arrays.sort(cs, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(cs[i]);
        }
        return res.toString();
    }

    public String replaceSpace(String s) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                s1.append("%20");
            else s1.append(s.charAt(i));
        }
        return s1.toString();
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        Collections.reverse(res);
        int[] array = res.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    public void appendTail(int value) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(value);
    }

    public int deleteHead() {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < n; j++) {
                int pre = matrix[i - 1][j];
                if (j > 0) {
                    pre = Math.min(pre, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    pre = Math.min(pre, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += pre;
                if (i == n - 1) {
                    res = Math.min(res, matrix[i][j]);
                }
            }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public List<String> commonChars(String[] words) {
        if (words.length == 0) return new ArrayList<>();
        int[] help = new int[26];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            help[words[0].charAt(i) - 'a'] += 1;
        }
        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                if (help[words[i].charAt(j) - 'a'] != 0 && help[words[i].charAt(j) - 'a'] > temp[words[i].charAt(j) - 'a']) {
                    temp[words[i].charAt(j) - 'a']++;
                }
            }
            help = temp;
        }
        for (int i = 0; i < 26; i++) {
            while ((help[i]--) != 0) {
                res.add(Character.toString(i + 'a'));
            }
        }
        return res;
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node p = new Node(cur.val);
            hashMap.put(cur, p);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copyNode = hashMap.get(cur);
            copyNode.next = hashMap.get(cur.next);
            copyNode.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0 || n == 0)
            return s;
        n = n % s.length();
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k < 1)
            return new int[]{};
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return res;
    }

    public int numWays(int n) {
        //f(n)=f(n-1)+f(n-2);
        int[] f = new int[101];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 101; i++) {
            f[i] = (int) ((f[i - 1] + f[i - 2]) % (1e9 + 7));
        }
        return f[n];
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums.length < 2 || nums == null)
            return new int[]{};
        int[] res = new int[2];
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                return res;
            }
            if (sum > target) {
                right--;
            } else left++;
        }
        return res;
    }


    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int subtractProductAndSum(int n) {
        int sum = 0, cal = 1;
        while (n != 0) {
            int t = n % 10;
            sum += t;
            cal *= t;
            n /= 10;
        }
        return cal - sum;
    }

    public int maxAbsoluteSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            //前缀和
        }
        Arrays.sort(nums);
        return nums[nums.length - 1] - nums[0];
    }

    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int res = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * minHeight);
            if (height[left] == minHeight) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            if (nums1[i] < nums2[j])
                i++;
            else j++;
        }
        return nums1[0] > nums2[0] ? nums2[0] * 10 + nums1[0] : nums1[0] * 10 + nums2[0];
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }
        long res = 0, cnt = 0;
        while (cnt * cost1 <= total) {
            res += (total - cnt * cost1) / cost2 + 1;
            cnt++;
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            res = Math.max(nums[i], res);
        }
        return res;
    }
    public static void main(String[] args) {
        Long l = 155L;
        //定义Long类型的时候需要在数据的最后加上一个标识符号
        Float f = 144.4f;
        //定义float类型的时候，也需要加上一个标识符,小数类型首选double类型
        double d = 144.4;
        //TODO:可以选择待完成的事项
    }
}
