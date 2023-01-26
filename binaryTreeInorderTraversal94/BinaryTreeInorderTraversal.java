package binaryTreeInorderTraversal94;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        //test case
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = inorderTraversal(node);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        //the order is like this: left-root-right
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private static void recursion(TreeNode node, List<Integer> list) {
        if (node!=null) {
            recursion(node.left, list);
            list.add(node.val);
            recursion(node.right, list);
        }
    }
}
