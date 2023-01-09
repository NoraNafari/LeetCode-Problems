package palindromeLinkedList234;

import shared.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        //test case
        ListNode testNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(testNode));
    }

    //Solution: find the middle using two fast and slow pointers
    //reverse the second half
    //compare the two
    public static boolean isPalindrome(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prev;
        ListNode temp;

        ListNode firstHalf = new ListNode(0);
        while (fastNode!=null && fastNode.next!=null) {
            slowNode = slowNode.next;
            firstHalf.next = slowNode;
            fastNode = fastNode.next.next;
        }

        //keep track of previous nodes
        prev = slowNode;
        slowNode = slowNode.next;
        prev.next = null;
        //reverse first half

        while (slowNode!=null) {
            temp = slowNode.next;
            slowNode.next = prev;
            prev = slowNode;
            slowNode = temp;
        }

        fastNode = head;
        slowNode = prev;
        while (slowNode != null) {
            if (fastNode.val != slowNode.val) {
                return false;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return true;
    }
}
