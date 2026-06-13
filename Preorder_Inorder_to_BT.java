import java.util.ArrayList;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
        }
        TreeNode root =k(pre, inorder, 0, inorder.length - 1, 0);
        return root;
    }

    TreeNode k(ArrayList<Integer> pre, int[] inorder, int i, int j, int pointer) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(pre.get(0));
        pre.removeFirst();
        for (int j2 = i; j2 <= j; j2++) {
            if (root.val == inorder[j2]) {
                pointer = j2;
                break;
            }
        }

        root.left = k(pre, inorder, i, pointer - 1, pointer);
        root.right = k(pre, inorder, pointer + 1, j, pointer);

        return root;
    }
}

public class Preorder_Inorder_to_BT {
    public static void main(String[] args) {
        Solution a = new Solution();
        int pre[] = { 3, 9, 20, 15, 7 };
        int in[] = { 9, 3, 15, 20, 7 };
        a.buildTree(pre, in);
    }
}
