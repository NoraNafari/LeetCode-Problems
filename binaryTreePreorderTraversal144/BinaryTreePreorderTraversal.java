package binaryTreePreorderTraversal144;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {

        //test case:
        //[1,null,2,3]
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2, new TreeNode(3), null);
        List<Integer> integers = preorderTraversal(node);
        for (Integer integer :
                integers) {
            System.out.println(integer);
        }
    }

    //recursive solution contains checking the root. then checking the left subtree
    // and after that, checking the right subtree.
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addValue(root, result);
        return result;
    }

    public static void addValue(TreeNode node, List<Integer> res) {
        if (node!=null) {
            res.add(node.val);
        }
        if (node!=null && node.left!=null) {
            addValue(node.left, res);
        }
        if (node!=null && node.right!=null) {
            addValue(node.right, res);
        }
    }

}
