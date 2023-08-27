//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			int [][] M = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.sumDiagonal(N, M));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int sumDiagonal(int n, int [][] matrix) {
		//Write your code here 
		
		int leftSum = 0;
        int rightSum = 0;
        int totalSum = 0;
        int j= n-1;
        for(int i=0;i<n;i++){
            
            leftSum += matrix[i][i];
            rightSum += matrix[i][j];
            j--;
        }
        
        // totalSum = leftSum + rightSum;
        
        // if(n%2 != 0){
        //     int index = (int) n/2;
        //     int mid = matrix[index][index];
        //     totalSum -= mid;
        // }
        
        
        return leftSum;
        
		
	}
}