//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int low = 0;
        int high = n - 1;
        int firstOccurrence = -1; // Initialize the first occurrence to -1

        // Binary search to find the first occurrence of x
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid integer overflow

            if (arr[mid] == x) {
                firstOccurrence = mid; // Update the first occurrence
                high = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (firstOccurrence == -1) {
            list.add(-1);
            list.add(-1);
            return list; // Element x is not found in the array
        }

        int lastOccurrence = firstOccurrence; // Initialize the last occurrence to the first occurrence

        // Binary search to find the last occurrence of x
        low = firstOccurrence + 1;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid integer overflow

            if (arr[mid] == x) {
                lastOccurrence = mid; // Update the last occurrence
                low = mid + 1; // Continue searching on the right side
            } else {
                high = mid - 1;
            }
        }

        list.add(firstOccurrence);
        list.add(lastOccurrence);

        return list;

        
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends