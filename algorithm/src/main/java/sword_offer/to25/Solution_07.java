package sword_offer.to25;


import java.util.HashMap;
import java.util.Map;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
public class Solution_07 {
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    private Map<Integer, Integer> indexMap;

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight,
                               int[] midOrder, int midLeft, int midRight) {

        if (preLeft > preRight || midLeft > midRight) {
            return null;
        }
        int rootValue = preOrder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        int pIndex = indexMap.get(rootValue);

        root.left = buildTree(preOrder, preLeft + 1, preLeft + pIndex - midLeft, midOrder, midLeft, pIndex - 1);
        root.right = buildTree(preOrder, preLeft + pIndex - midLeft + 1, preRight, midOrder, pIndex + 1, midRight);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1,inorder, 0, n - 1);
    }
}

