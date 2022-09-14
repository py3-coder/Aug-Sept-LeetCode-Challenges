/*
1457. Pseudo-Palindromic Paths in a Binary Tree
Medium
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Example 1:

Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:

Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 9
*/
class Solution {
    public static boolean checkPalindrome(ArrayList<Integer> list){
        int len = list.size();
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i: list){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count= 0;
        for(int a : map.values()){
            if(a%2==1){
                count++;
            }
        }
        return (count<=1)?true:false;
    }
   public void path(ArrayList<ArrayList<Integer>> res , ArrayList<Integer> subres,TreeNode  root){
       if(root == null) return ;
       subres.add(root.val);
       if(root.left==null && root.right == null){
           res.add(new ArrayList<Integer>(subres));
       }
       if(root.left!=null){
           path(res,subres,root.left);
           subres.remove(subres.size()-1);
       }
       if(root.right!=null){
           path(res,subres,root.right);
           subres.remove(subres.size()-1);
       }
       
   }
    public int pseudoPalindromicPaths (TreeNode root) {
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
         ArrayList<Integer> subres = new ArrayList<>();
         path(res,subres,root);
        System.out.print(res);
         int counter =0;
         for(ArrayList<Integer> arr : res){
            if(checkPalindrome(arr) == true){
                counter++;
            } 
         }
        return counter;
    } 
}
/*
Test Case : 53/56;
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return canPanlindromepossible(root, new HashSet());
    }
    public int canPanlindromepossible(TreeNode node , Set<Integer> num){
        if(node==null) return 0;
        if(num.contains(node.val)){
            num.remove(node.val);
        }else{
            num.add(node.val);
        }
        if(node.left==null && node.right==null){
            return num.size()<=1?1:0;
        }
        int left =canPanlindromepossible(node.left,new HashSet(num));
        int right =canPanlindromepossible(node.right,new HashSet(num));
        return left+right;     
    }
}
