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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            if(result == null){
                curr = new ListNode(sum%10);
                result = curr;
            }else{
                curr.next = new ListNode(sum%10);
                curr = curr.next;
            }
            carry = sum/10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return result;
    }
}
