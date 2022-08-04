/*
August-04-22
Day:04
858. Mirror Reflection
Medium
Link :https://leetcode.com/problems/mirror-reflection/

There is a special square room with mirrors on each of the four walls. Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Given the two integers p and q, return the number of the receptor that the ray meets first.

The test cases are guaranteed so that the ray will meet a receptor eventually.

 

Example 1:


Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
Example 2:

Input: p = 3, q = 1
Output: 1
 

Constraints:

1 <= q <= p <= 1000
*/
/*
Code
*/
class Solution {
    public int mirrorReflection(int p, int q) {
       int ext =q;
       int ref =p;
        while(ext%2==0 && ref%2==0){
            ext/=2;
            ref/=2;
        }
       if(ext%2 ==0 && ref%2!=0){
           return 0;
       }if(ext%2 !=0 && ref%2!=0){
           return 1;
       }if(ext%2!=0 && ref%2==0){
           return 2;
       }
        return -1;
    }
}

