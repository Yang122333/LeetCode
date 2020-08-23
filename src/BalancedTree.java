import java.util.LinkedList;
import java.util.Stack;

/**
 * 110. 平衡二叉树
 */
// Definition for a binary tree node.
class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BalancedTree {
    public static TreeNode create() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        return root1;
    }

    public static void main(String[] args) {
//        System.out.println(isBalanced(create()));
        depthFirstDigui(create());

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        root.val = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int max = 0, min = 1000;
        if (root.left == null || root.right == null) {
            min = 1;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left != null) {
                node.left.val = node.val + 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + 1;
                queue.add(node.right);
            }
            if (node.right == null || node.left == null) {
                max = Math.max(max, node.val);
                min = Math.min(min, node.val);
            }
        }
        if (max - min > 1) {
            return false;
        }
        return true;
    }

    public static boolean isBalanced1(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        return false;
    }


    public static void depthFirst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    public static void depthFirstDigui(TreeNode root){
        if(root != null){
            System.out.println(root.val);
        }
        if(root.left != null){
            depthFirstDigui(root.left);
        }
        if(root.right != null){
            depthFirstDigui(root.right);
        }
    }

}
