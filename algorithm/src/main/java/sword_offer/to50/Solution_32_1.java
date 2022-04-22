package sword_offer.to50;

import sword_offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution_32_1 {

    public int[] levelOrder4Roy(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            list.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }


}