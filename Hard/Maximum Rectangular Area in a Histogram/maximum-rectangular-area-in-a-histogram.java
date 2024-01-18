//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long n) 
    {
        long maxArea = 0;
        long nextSmallerLeft[] = new long[(int)n];
        long nextSmallerRight[] = new long[(int)n];
        
        Stack<Integer> s = new Stack<>();
        
        //Next Smaller Right
        for(int i=(int)n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }          
            if(s.isEmpty()){
                nextSmallerRight[i] = n;
            }else{
                nextSmallerRight[i] = s.peek();
            }            
            s.push(i);   //pushing index in the stack
        }
        
        s = new Stack<>();  // empty the stack
        //Next Smaller Left
        for(int i=0;i<(int)n;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }            
            if(s.isEmpty()){
                nextSmallerLeft[i] = -1;
            }else{
                nextSmallerLeft[i] = s.peek();
            }           
            s.push(i);
        }
         
        // Calculate Area
        // width = j-i-1 --> nextSmallerRight[i] - nextSmallerLeft[i] -1
        for(int i=0;i<(int)n;i++){
            long height = heights[i];
            long width = (nextSmallerRight[i] - nextSmallerLeft[i]) - 1;
            long currArea = height * width;
            
            maxArea = Math.max(currArea,maxArea);
        }
        
        return maxArea;
    }
        
}



