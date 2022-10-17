/*
1335. Minimum Difficulty of a Job Schedule
Hard

You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days.
The difficulty of a day is the maximum difficulty of a job done on that day.
You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

 

Example 1:


Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7 
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.
 

Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10
*/
class Solution {
    //Recursion: because here we need to check all possiblities and We need to opt mini for all ways
    // IBH method implemented:Induction,Base Case Hypothesis..
    public static int solveR(int indx ,int[] jd,int d){
        //Base Case :
        if(d==1) return max(jd,indx);
        else{
            int val =Integer.MIN_VALUE;
            int res =Integer.MAX_VALUE;
            // Cutting at diff length till len-d+1 to get min:
            for(int i=indx;i<jd.length-d+1;i++){
                val = Math.max(val,jd[i]);
                res =Math.min(res,val+solveR(i+1,jd,d-1));
            }
            return res;
        }
    }
    public static int max(int[] arr,int idx){
        int res =0;
        for(int i=idx;i<arr.length;i++){
            res = Math.max(res,arr[i]);
        }
        return res;
    }
    //Memoization ~ Recursion + Memory
    public static int solveMemo(int indx,int[] jd,int d,int dp[][]){
        if(d==1) return max(jd,indx);
        if(dp[indx][d]!=-1) return dp[indx][d];
        else{
            int val =Integer.MIN_VALUE;
            int res =Integer.MAX_VALUE;
            for(int i=indx;i<jd.length-d+1;i++){
                val = Math.max(val,jd[i]);
                res =Math.min(res,val+solveMemo(i+1,jd,d-1,dp));
            }
            return dp[indx][d]=res;
        }
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length) return -1;
        //return solveR(0,jobDifficulty,d);
        int dp[][] =new int[jobDifficulty.length+1][d+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solveMemo(0,jobDifficulty,d,dp);
    }
}
