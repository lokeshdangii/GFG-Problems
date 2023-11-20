//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
       int temp[] = new int[n];
       
       for(int i=0;i<n;i++){
        temp[i] = (arr1[i] ? 1 : 0) - (arr2[i] ? 1 : 0);
       }
       
       return sumZero(temp);
    }

    // sum = 0 function
    int sumZero(int A[])
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int pre_sum = 0, res = 0;

        for (int i = 0; i < A.length; i++) {
            pre_sum += A[i];

            if (pre_sum == 0) {
                res = i + 1;
            }

            if (!hm.containsKey(pre_sum)) {
                hm.put(pre_sum, i);
            } else {
                res = Math.max(res, i - hm.get(pre_sum));
            }
        }

        return res;
    }
} 