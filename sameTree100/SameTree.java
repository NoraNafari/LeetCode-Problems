package sameTree100;

import shared.TreeNode;

public class SameTree {

    public static void main(String[] args) {

        //test case
        TreeNode first = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode second = new TreeNode(1, new TreeNode(3), null);
        System.out.println(isSameTree(first, second));
    }

    //You just have to check the right and left sub-trees recursively
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)  {
            return true;
        }
        if ((p == null || q == null) || (p.val!=q.val)) {
            return false;
        }

        Boolean leftTree = isSameTree(p.left, q.left);
        Boolean rightTree = isSameTree(p.right, q.right);

        return leftTree && rightTree;
    }
}
