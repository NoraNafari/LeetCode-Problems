package maximumDepthOfBinaryTree104;

import shared.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        //test case

        TreeNode test01 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepth(test01));
    }

    public static int maxDepth(TreeNode root) {
        return checkRecursively(root, 0);
    }

    private static int checkRecursively(TreeNode node, int result) {
        if (node!=null) {
            result++;
            int rightSubtree = checkRecursively(node.right, result);
            int leftSubtree = checkRecursively(node.left, result);
            result = java.lang.Math.max(rightSubtree, leftSubtree);
        }
        return result;
    }
}
