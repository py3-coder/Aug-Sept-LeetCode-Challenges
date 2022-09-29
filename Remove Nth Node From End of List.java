/*
19. Remove Nth Node From End of List
Medium

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
*/
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
    public int length(ListNode head){
        if(head==null) return 0;
        int length =0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            length +=1;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head)+1-n;
        if(length(head)==1 && n==1){
            return null;
        }
        if(len==1){
            return head.next;
        }
        ListNode prev  = head;
        ListNode curr = head;
        while(len>1){
            prev = curr ;
            curr = curr.next;
            len--;
        }
        prev.next =curr.next;
        curr.next =null;
        return head;
    }
}
