/*
838. Push Dominoes
Medium

There are n dominoes in a line, and we place each domino vertically upright. In the beginning,
we simultaneously push some of the dominoes either to the left or to the right.
After each second, each domino that is falling to the left pushes the adjacent domino on the left. 
Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Example 1:
Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Example 2:
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 
Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.
*/
//CODE :
class Solution {
    public String pushDominoes(String dominoes) {
        //the state of dominoes will be determined by its nearest 'R' or 'L'
        
        int n = dominoes.length();
        int[] lf = new int[n]; //record the nearest 'R' on the left of dominoes[i]
        int[] rh = new int[n]; //record the nearest 'L' on the right of dominoes[i]
        
        for (int i = 0; i < n; i ++) {
            //current index is 'R'
            if (dominoes.charAt(i) == 'R') {
                lf[i] = 0;
            }
            //no nearest 'R' for right dominoes
            else if (dominoes.charAt(i) == 'L') {
                lf[i] = Integer.MAX_VALUE;
            }
            //find nearest 'R'
            else {
                //no nearest 'R'
                if (i == 0 || lf[i-1] == Integer.MAX_VALUE)
                    lf[i] = Integer.MAX_VALUE;
                //nearest 'R' exists
                else
                    lf[i] = lf[i-1] + 1;
            }
        }
        for (int i = n-1; i >= 0; i --) {
            if (dominoes.charAt(i) == 'L') {
                rh[i] = 0;
            }
            else if (dominoes.charAt(i) == 'R') {
                rh[i] = Integer.MAX_VALUE;
            }
            else {
                if (i == n-1 || rh[i+1] == Integer.MAX_VALUE)
                    rh[i] = Integer.MAX_VALUE;
                else
                    rh[i] = rh[i+1] + 1;
            }
        }
        
        
        char[] ans = new char[n];
        for (int i = 0; i < n; i ++) {
            if (lf[i] < rh[i])
                ans[i] = 'R';
            else if (lf[i] > rh[i])
                ans[i] = 'L';
            else
                ans[i] = '.';
        }
        return String.valueOf(ans);
    }
}
