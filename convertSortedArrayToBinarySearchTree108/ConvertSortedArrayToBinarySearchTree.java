package convertSortedArrayToBinarySearchTree108;

import shared.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

        //test case
        int[] nums = new int[] {-10,-3,0,5,9};

        TreeNode node = sortedArrayToBST(nums);
        //expected: 0, 5 , -10 , -3, 9
        System.out.println(node.val);
        System.out.println(node.right.val);
        System.out.println(node.left.val);
        System.out.println(node.left.right.val);
        System.out.println(node.right.right.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createRecursively(nums, nums.length - 1, 0);
    }

    //Like similar questions, we are going to use recursion on the array to create the tree
    private static TreeNode createRecursively(int[] nums, int right, int left) {
        //The ending condition for recursion
        if (left > right) {
            return null;
        }
        //find the middle
        int mid = (right + left) / 2;
        //set it as root
        TreeNode node = new TreeNode(nums[mid]);
        //use recursion to do the same for right and left sub-trees
        node.right = createRecursively(nums, right, mid + 1);
        node.left = createRecursively(nums, mid - 1, left);
        return node;
    }
}
