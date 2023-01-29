package linkedListCycle141;

import shared.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        //test case

        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode last = new ListNode(-4);
        first.next = second;
        second.next = third;
        third.next = last;
        last.next = second;
        System.out.println(hasCycle(first));

        //test case 2
        ListNode test02 = new ListNode(1);
        System.out.println(hasCycle(test02));
    }

    //we have to create two pointers, one fast and one slow
    //the slower will move one by one
    //the faster will move two by two
    //if the linked list contains a loop, there will be a point when these pointers meet
    public static boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer.equals(fastPointer)){
                return true;
            }
        }
        return false;
    }
}
