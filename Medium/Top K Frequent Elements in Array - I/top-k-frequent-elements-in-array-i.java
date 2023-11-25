//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        
        int n = nums.length;
        int[] result = new int[k];

        // HashMap to store key and frequency (element, count)
        Map<Integer, Integer> hm = new HashMap<>();

        for (int ele : nums)
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);

        // Use a priority queue to keep track of top k elements based on frequencies and values
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue())
        );

        // Add elements from the HashMap to the priority queue
        pq.addAll(hm.entrySet());

        // Extract elements from the priority queue
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}

/*
int n = nums.length;
        int result[] = new int[k];
    
        // HashMap to store key and frequency (element, count)     
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int ele : nums)
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        
        // Create an ArrayList of values from the HashMap
        ArrayList<Integer> frequencies = new ArrayList<>(hm.values());
        
        // Sort the ArrayList in reverse order
        Collections.sort(frequencies, Collections.reverseOrder());
        
        // Loop from 0 to k and find the corresponding key from HashMap
        for (int i = 0; i < k; i++) {
            int frequency = frequencies.get(i);
            
            for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
                if (e.getValue() == frequency) {
                    result[i] = e.getKey();
                    hm.remove(e.getKey());
                    break;
                }
            }
        }
        
        return result;
*/