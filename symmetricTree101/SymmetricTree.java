package symmetricTree101;

import shared.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        //test case
        TreeNode test01 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(test01));
        //test case with one node
        TreeNode test02 = new TreeNode(1);
        System.out.println(isSymmetric(test02));
        //asymmetric
        TreeNode test03 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(isSymmetric(test03));
    }

    //we check if the two subtrees are symmetric or not (recursively)
    //if the tree is symmetric, then the right's right value must be equal
    // to left's left value and reverse
    //It's easier to imagine than to write down!
    public static boolean isSymmetric(TreeNode root) {
        return checkRecursively(root.right, root.left);
    }

    private static Boolean checkRecursively(TreeNode right, TreeNode left) {
        if (right!=null && left!=null) {
            if (right.val==left.val) {
                Boolean rightSubtree = checkRecursively(right.left, left.right);
                if (rightSubtree) {
                    return checkRecursively(right.right, left.left);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else return right == null && left == null;
    }
}
