//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        long ms = Integer.MIN_VALUE;
        long cs = 0;
        int n = arr.length;
        
        for(int i=0;i<arr.length;i++){
            cs += arr[i];
            
            if(cs < 0)
                cs = 0;
                
            ms = Math.max(cs,ms);
        }
        
        
        boolean all_negative = true;
        long smallest = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                all_negative = false;
            }
            
            if(arr[i] > smallest){
                smallest = arr[i];
            }
        }
        
        if(all_negative)
            return smallest;
        
        return ms;
    }
}
