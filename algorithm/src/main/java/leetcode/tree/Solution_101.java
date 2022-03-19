package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return access(root.left, root.right);
    }

    public boolean access(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return access(left.left, right.right)
                && access(left.right, right.left);
    }


}