class Solution {
    boolean checkChildrenSum(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.right != null) {
            sum += root.right.val;
        }
        boolean a = true;
        if (sum == root.val) {
            a = true;
        } else {
            a = false;
        }
        return checkChildrenSum(root.left) && checkChildrenSum(root.right) && a;
    }
}

public class childern_sum {
    public static void main(String[] args) {
        Solution a = new Solution();
        TreeNode root = new TreeNode(35);

        root.left = new TreeNode(20);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        System.out.println(a.checkChildrenSum(root));
        
    }
}
