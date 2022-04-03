package sword_offer.to50;


import sword_offer.TreeNode;

public class Solution_28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if ((l != null && r != null) && (l.val == r.val)) {
            return recur(l.left, r.right) && recur(l.right, r.left);
        } else {
            return false;
        }
    }
}