package sword_offer.to50;


import sword_offer.TreeNode;

public class Solution_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;;
        root.left = mirrorTree(root.right);;
        root.right = mirrorTree(temp);
        return root;
    }

}