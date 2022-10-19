/*
692. Top K Frequent Words
Medium

Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.


Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 
Constraints:
1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String ,Integer>  map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //Priority Queue with custom comperator using lembda exp:
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        (a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue());
        
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
}
