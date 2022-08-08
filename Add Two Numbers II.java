/*
445. Add Two Numbers II
Medium
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
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
    public int length(ListNode l){
        int length=0;
        while(l!=null){
            length++;
            l = l.next;
        }
        return length;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 =length(l2);
        int carry =0;
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while(l1!=null || l2!=null){
            int val1 =0;
            int val2 =0;
            if(len1>=len2){
                val1 =l1.val;
                len1--;
                l1 =l1.next;
            }
            if(len2>=len1+1){
                val2 = l2.val;
                len2--;
                l2 =l2.next;
            }
            int sum =val1+val2;
            s1.push(sum);
            //System.out.print(+" ");
        }
        int due=0;
        int a=0;
        while(!s1.isEmpty() || due !=0){
            if(!s1.isEmpty()){
                a =s1.pop();
            }else{
                a=0;
            }
            a= a+due;
            s2.push((a)%10);
            //System.out.print(s2.push((a)%10)+" ");
            due=0; 
            if(a>9){
                due =a/10;
            }
        }
        ListNode node= new ListNode(0);
        ListNode temp =node;
        while(!s2.isEmpty()){
            ListNode curr = new ListNode(s2.pop());
            temp.next = curr;
            temp = curr;
        }
        return node.next;
    }
}
