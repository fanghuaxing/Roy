package sword_offer.to50;


import sword_offer.TreeNode;

import java.util.*;

public class Solution_32_3 {
    boolean num = true;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        levelOrder(nodes, result);
        return result;
    }

    public void levelOrder(Stack<TreeNode> stack, ArrayList<List<Integer>> result) {
        if (stack.isEmpty()) {
            ;
        } else {
            Stack<TreeNode> nodes = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                if (num){
                    if (pop.left!=null){nodes.push(pop.left);}
                    if (pop.right!=null){nodes.push(pop.right);}
                }else {
                    if (pop.right!=null){nodes.push(pop.right);}
                    if (pop.left!=null){nodes.push(pop.left);}
                }
            }
            num = !num;
            result.add(list);
            levelOrder(nodes, result);
        }
    }

    public List<List<Integer>> levelOrder4Roy(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}