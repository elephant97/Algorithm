/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int upDisits = 0;
    boolean breakPoint = false;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer;
        ListNode head;

        answer = add(l1, l2);
        head = answer;
        while(true) {
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            answer.next = add(l1, l2);
            answer = answer.next;
            if(breakPoint) break;
        }

        
        return head;
    }

    public ListNode add(ListNode l1, ListNode l2){
        int l1Val = 0;
        int l2Val = 0;
        if(l1 != null) l1Val = l1.val;
        if(l2 != null) l2Val = l2.val;
        int valSum = l1Val+l2Val+upDisits;

        upDisits = valSum/10;

        if(l1 == null && l2 == null){
            breakPoint = true;
            if(upDisits > 0)
                return new ListNode((int)valSum%10, new ListNode(upDisits));
            if(valSum == 0)
                return null;
        }

        return new ListNode((int)valSum%10);
    }
}


