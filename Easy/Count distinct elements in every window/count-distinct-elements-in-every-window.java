//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int distinctCount = 0;

        // Count distinct elements in the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
            if (freqMap.get(A[i]) == 1) {
                distinctCount++;
            }
        }

        list.add(distinctCount);

        // Slide the window and update distinct count using the frequency map
        for (int i = k; i < n; i++) {
            // Remove the leftmost element from the window
            freqMap.put(A[i - k], freqMap.get(A[i - k]) - 1);
            if (freqMap.get(A[i - k]) == 0) {
                distinctCount--;
            }

            // Add the new element to the window
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
            if (freqMap.get(A[i]) == 1) {
                distinctCount++;
            }

            list.add(distinctCount);
        }

        return list;
    }
}











// class Solution
// {
//     // count distinct element
//      int distinctCount(int[] nums, int idx, int k) {
//         int n = nums.length;
        
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int i=idx; i<idx+k;i++){
//             set.add(nums[i]);
//         }
        
//         return set.size();
//     }
    
//     ArrayList<Integer> countDistinct(int A[], int n, int k)
//     {
//         ArrayList<Integer> list = new ArrayList<>();
//       int idx = 0;
//       for(int i=0;i<=n-k;i++){
//           int count = distinctCount(A, idx, k);
//           idx++;
//           list.add(count);
//       }
      
//       return list;
//     }
    
    
    
// }

