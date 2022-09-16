/*
1770. Maximum Score from Performing Multiplication Operations
Medium

1927

446

Add to List

Share
You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

 

Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.
Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score. 
The total score is 50 + 15 - 9 + 4 + 42 = 102.
 

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
*/
// Code 1:  TC- O(N*M)  SC - O(M*M)
class Solution {
    public int tabulaion(int[] nums , int[] mul){
        int n = nums.length;
        int m = mul.length;
        
        int dp[][]  = new int[m+1][m+1];
        
        for(int i=m-1;i>=0;i--){
            for(int st=i;st>=0;st--){
                int f = dp[i+1][st+1]+mul[i]*nums[st];
                int b = dp[i+1][st]+mul[i]*nums[n-1-(i-st)];
                
                dp[i][st] =Math.max(f,b);   
            }
        }
        return dp[0][0];
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        return tabulaion(nums,multipliers);
    }
}
