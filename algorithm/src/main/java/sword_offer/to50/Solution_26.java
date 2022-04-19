package sword_offer.to50;

import sword_offer.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Solution_26 {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if ((a == null || b == null)) return false;
        return recur(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}