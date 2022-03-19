package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历二叉树, 从rootNode开始,
 * 读取此rootNode节点,再访问左节点
 * 直到子节点没有左节点,读取此节点的右节点
 * 1. 递归的方式
 * 2. 可以用Deque(LinkedList)模拟
 *
 */
public class Solution_114 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        accessTree(root, list);
        return list;
    }

    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {return;}
        res.add(root.val);
        accessTree(root.left, res);
        accessTree(root.right, res);
    }

    public List<Integer> preorderTraversalByStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}

