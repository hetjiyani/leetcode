import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        TreeMap<Long, TreeNode> a = new TreeMap<>();
        a.put(1l, root);
        int max = 0;
        while (!a.isEmpty()) { 

            max = Math.max(max, (int)(a.lastEntry().getKey() - a.firstEntry().getKey() )+ 1);
            System.out.println((a.lastEntry().getKey() - a.firstEntry().getKey() )+ 1);
            a = add(a);
        }
        return max;
    }

    TreeMap<Long, TreeNode> add(TreeMap<Long, TreeNode> a) {
        TreeMap<Long, TreeNode> tmp = new TreeMap<>();
        for (Map.Entry<Long, TreeNode> x : a.entrySet()) {
            if (x.getValue().left != null) {
                tmp.put(2 * x.getKey(), x.getValue().left);
            }
            if (x.getValue().right != null) {
                tmp.put(2 * x.getKey() + 1, x.getValue().right);
            }
        }
        return tmp;
    }
}

public class Max_width_BT {
    public static void main(String[] args) {
        Solution a = new Solution();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);
        System.out.println(a.widthOfBinaryTree(root));
        ;
    }
}
