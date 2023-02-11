package addTwoNumbers2;

import shared.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        //test case
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result01 = addTwoNumbers(l1, l2);
        while (result01!=null) {
            System.out.println(result01.val);
            result01 = result01.next;
        }
        //test case
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l4 = new ListNode(9);
        ListNode result02 = addTwoNumbers(l3, l4);
        while (result02!=null) {
            System.out.println(result02.val);
            result02 = result02.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //result
        ListNode result =  new ListNode();
        //start from head of two
        ListNode current = result;
        //variable for carry count
        int carry = 0;
        //check if node is null
        while (l1!=null || l2!=null || carry!=0) {
            int currentNumber = 0;
            if (l1!=null) {
                currentNumber+=l1.val;
            }
            if (l2!=null) {
                currentNumber+=l2.val;
            }
            currentNumber+=carry;
            current.next = new ListNode(currentNumber%10);
            current = current.next;
            if (currentNumber<10) {
                carry=0;
            }
            if (currentNumber>=10) {
                carry=1;
            }

            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }

        return result.next;
    }
}
