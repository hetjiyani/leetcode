import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int timeToBurnTree(TreeNode root, TreeNode start) {
        HashMap<TreeNode, TreeNode> a = new HashMap<>();
        ArrayList<TreeNode> Q = new ArrayList<>();
        ArrayList<TreeNode> visit = new ArrayList<>();
        Q.add(start);
        ParentAssign(root, a);
        int count = -1;
        while (Q.size() != 0) {
            count++;
            y(Q, visit, a);
        }
        return count;
    }

    void y(ArrayList<TreeNode> Q, ArrayList<TreeNode> visit, HashMap<TreeNode, TreeNode> a) {
        int size = Q.size();
        for (int i = 0; i < size; i++) {
            TreeNode re = Q.removeFirst();

            if (re.left != null && !visit.contains(re.left)) {
                Q.add(re.left);
            }
            if (re.right != null && !visit.contains(re.right)) {
                Q.add(re.right);
            }
            if (a.containsKey(re) && !visit.contains(a.get(re))) {
                Q.add(a.get(re));
            }
            visit.add(re);
        }
    }

    void ParentAssign(TreeNode root, HashMap<TreeNode, TreeNode> a) {
        if (root == null) {
            return;
        }

        if (root.left != null)
            a.put(root.left, root);
        if (root.right != null)
            a.put(root.right, root);

        ParentAssign(root.left, a);
        ParentAssign(root.right, a);
    }
}

public class Burning_BT {
    public static void main(String[] args) {
        Solution a = new Solution();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.right = new TreeNode(7);
        System.out.println(a.timeToBurnTree(root, root.left.left.right));
        ;
    }
}
