package LeetCode;

public class _112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root==null) return false;
        if (traversal(root, targetSum))
            return true;
        return false;
    }

    public boolean traversal(TreeNode node, int count) {
        if (node.left == null && node.right == null) {
            if (count == 0)
                return true;
            else return false;
        }
        if (node.left != null) {
            count -= node.left.val;
            if (traversal(node.left, count)) return true;
            count += node.left.val;
        }
        if (node.right != null) {
            count -= node.right.val;
            if (traversal(node.right, count))
                return true;
            count += node.right.val;
        }
        return false;
    }
}
