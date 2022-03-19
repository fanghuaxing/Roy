package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * 前序遍历二叉树, 从rootNode开始,access左节点直到左节点为null
 * 读取此rootNode节点,再访问父节点的右节点,再访问父节点
 * 直到子节点没有左节点,读取此节点的右节点
 * 1. 递归的方式
 * 2. 可以用Deque(LinkedList)模拟
 *
 */
public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        accessTree(root, list);
        return list;
    }

    public void accessTree(TreeNode root, List<Integer> list){
        if(root==null){return;} 
        accessTree(root.left,list);
        accessTree(root.right,list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversalByStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode prevAccess = null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prevAccess) {
                list.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}