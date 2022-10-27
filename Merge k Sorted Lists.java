/*
23. Merge k Sorted Lists
Hard

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/
class Solution {
    public ListNode merge2(ListNode l1,ListNode l2){
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        ListNode tail = fake;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next =l1;
                l1 =l1.next;
            }
            else{
                tail.next =l2;
                l2 =l2.next;
            }
            tail =tail.next;
        }
        tail.next = (l1!=null)?l1:l2;
        
        return fake.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        ListNode dummy= new ListNode(Integer.MIN_VALUE);
        ListNode m1 =dummy;
        for(int i=0;i<lists.length;i++){
             m1 = merge2(m1,lists[i]);
        }
        return dummy.next;
    }
}
