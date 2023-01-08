package removeNthNodeFromTheEndOfList19;

public class RemoveNthNodeFromTheEndOfList {

    public static void main(String[] args) {
        //test case
        //head = [1,2,3,4,5], n = 2
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd(node, 2);
        while (result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //General explanation: there are two pointers. one is n steps ahead of the other.
    //When the pointer that is ahead in the race reaches the end,
    // the first pointer is one step behind the element that is going to be deleted.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //create a dummy list node in order to keep the data that we're querying
        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode big = listNode;
        ListNode small = listNode;
        //move the big pointer n steps ahead of the small one
        for (int i = 0; i < n + 1; i++) {
            big = big.next;
        }

        //move the two pointers one by one until the pointer that is ahead
        //reaches the end
        while (big!=null) {
            big = big.next;
            small = small.next;
        }

        //skip one element
        small.next = small.next.next;
        return listNode.next;
    }
}
