package sword_offer.to75;


import sword_offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        midQuery(list, root);
        return list.get(list.size()-k);
    }

    public void midQuery(List<Integer> list, TreeNode root) {
        if (root == null) return;
        midQuery(list, root.left);
        list.add(root.val);
        midQuery(list, root.right);
    }

}