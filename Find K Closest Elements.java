/*

658. Find K Closest Elements
Medium
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 
Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 
Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

*/




/*
Runtime ~ 60 ms
TC -O(n)
SC- O(n)
*/

```
class Pair{
    int val1=0;
    int val2=0;
    Pair(int val1,int val2){
        this.val1 = val1;
        this.val2 =val2;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        List<Pair> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int abs =Math.abs(arr[i]-x);
            res.add(new Pair(abs,arr[i]));
        }
        Collections.sort(res,(a,b)->{
            return a.val1-b.val1;
        });
        for(Pair pp : res){
            if(k>0){
                result.add(pp.val2);
            }
            k--;
        }
        Collections.sort(result);
        return result;
    }
}
```
