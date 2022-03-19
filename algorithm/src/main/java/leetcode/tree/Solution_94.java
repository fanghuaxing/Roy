package leetcode.tree;

import java.util.*;

/**
 * 中序遍历二叉树, 从rootNode开始,只要有左节点就access
 * 直到子节点没有左节点,读取此节点,再读取此节点的根节点,在读取右节点
 * 1. 递归的方式
 * 2. 可以用Deque(LinkedList)模拟
 *
 */
public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        accessTree(root, list);
        return list;
    }

    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {return;}
        accessTree(root.left, res);
        res.add(root.val);
        accessTree(root.right, res);
    }

    public List<Integer> inorderTraversalByStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}

