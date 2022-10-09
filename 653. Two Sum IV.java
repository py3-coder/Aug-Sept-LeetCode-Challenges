/*
653. Two Sum IV - Input is a BST
Easy
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        for(int i = 0, j = res.size()-1; i<j;){
            if(res.get(i) + res.get(j) == k)return true;
            if(res.get(i) + res.get(j) < k)i++;
            else j--;
        }
        return false;
    }
    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
