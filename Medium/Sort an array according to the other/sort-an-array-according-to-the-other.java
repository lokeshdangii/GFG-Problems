//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int arr1[], int N, int arr2[], int M)
    {
        TreeMap<Integer, Integer> hm = new TreeMap<>();

        // Store frequencies of each element in arr1
        for (int ele : arr1) {
            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }

        int idx = 0;

        // Place elements of arr2 in arr1 according to their order in arr2
        for (int ele : arr2) {
            if (hm.containsKey(ele)) {
                for (int i = 0; i < hm.get(ele); i++) {
                    arr1[idx++] = ele;
                }
                hm.remove(ele); // Remove the element once it is placed
            }
        }

        // Collect remaining elements
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }

        // Sorting the remaining elements
        Collections.sort(list);

        // Add remaining sorted elements to arr1
        for (int i = 0; i < list.size(); i++) {
            arr1[idx++] = list.get(i);
        }

        return arr1;

    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends