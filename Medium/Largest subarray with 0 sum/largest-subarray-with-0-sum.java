//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int A[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int pre_sum=0, res =0;
        
        for(int i=0;i<A.length;i++){
            pre_sum += A[i];
            
            if(pre_sum == 0){
                res = i+1;
            }
            
            if(hm.containsKey(pre_sum-0) == false){
                hm.put(pre_sum,i);
            }
            
            if(hm.containsKey(pre_sum-0)){
                res = Math.max(res,Math.abs(i-hm.get(pre_sum-0)));
            }
        }
        
        return res;
    }
}