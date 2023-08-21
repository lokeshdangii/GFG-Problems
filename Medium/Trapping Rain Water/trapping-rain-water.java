//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int height[], int n) { 
        // Your code here
        long water = 0;

        int left[] = new int[n];  
        int right[] = new int[n];

        int left_max = height[0];
        int right_max = height[n-1];


        // to make left max Boundaries
        for(int i=0;i<n;i++){
            if(height[i]>left_max){
                left[i] = height[i];
                left_max = height[i];
            }else{
                left[i] = left_max;
            }
        }

        // to set right max boundaries
        for(int i=n-1;i>=0;i--){
            if(height[i]>right_max){
                right[i] = height[i];
                right_max = height[i];
            }else{
                right[i] = right_max;
            }
        }

        // to calculate trapped water
        for(int i=0;i<n-1;i++){
            water = water + Math.abs(height[i] - Math.min(left[i],right[i]));
        }
        return water;
    } 
}


