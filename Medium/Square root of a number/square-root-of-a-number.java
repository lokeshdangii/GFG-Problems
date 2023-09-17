//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here  
		if (x == 0 || x == 1) 
		{
            return x;
        }

        long low = 1;
        long high = x;
        long root = 0;

        while(low<=high){

            long mid = low + (high - low) / 2;
            long msq = mid * mid;

            if (msq == x){
                return mid;
            }else if(msq > x){
                high = mid -1;
            }else{
                low = mid +1;
                root = mid;
            }
        }

        return root;
	 }
}
