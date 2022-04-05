package sword_offer.to75;


import sword_offer.TreeNode;

public class Solution_55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int i = maxDepth(root.left) - maxDepth(root.right);
        boolean result = Math.abs(i) <= 1;
        if (result) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}