import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> a = new HashMap<>();
        ArrayList<TreeNode> visit = new ArrayList<>();
        ArrayList<TreeNode> Q = new ArrayList<>();
        Q.add(target);

        k(root, a);
        // System.out.println(a.get(root).val);
        for (int i = 0; i < k; i++) {
            y(root, target, k, visit, Q, a);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Q.size(); i++) {
            ans.add(Q.get(i).val);
        }
        return ans;
    }

    void y(TreeNode root, TreeNode target, int k, ArrayList<TreeNode> visit, ArrayList<TreeNode> Q,HashMap<TreeNode, TreeNode> a) {
        int size = Q.size();
        for (int i = 0; i < size; i++) {
            TreeNode s = Q.removeFirst();
            // System.out.println("remove "+s.val);

            if (!visit.contains(s.left) && s.left != null){
                // System.out.println("add l+"+s.left.val);
                Q.add(s.left);
            }
               
            if (!visit.contains(s.right) && s.right != null){
                // System.out.println("add r+"+s.right.val);
                Q.add(s.right);
            }
                // System.out.println(a.containsKey(s));
                // System.out.println(visit.contains(s));
                // System.out.println(a.get(s).val);
            if (a.containsKey(s) && !visit.contains(a.get(s))){
                Q.add(a.get(s));
            }
                
            
            visit.add(s);
        }
        // for (int j = 0; j < Q.size(); j++) {
        //             System.out.print(Q.get(j).val+" ");
        //         }

    }

    void k(TreeNode root, HashMap<TreeNode, TreeNode> a) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            a.put(root.left, root);
        }
        if (root.right != null) {
            a.put(root.right, root);
        }

        k(root.left, a);
        k(root.right, a);
    }

}

public class All_node_distance {
    public static void main(String[] args) {
        Solution a = new Solution();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(a.distanceK(root, root.left, 2));
        ;
    }
}
