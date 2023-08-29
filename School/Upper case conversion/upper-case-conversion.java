//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String str = br.readLine();
                    Solution ob = new Solution();
                    System.out.println(ob.transform(str));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String transform(String s)
    {
        // code here
        StringBuilder result = new StringBuilder("");
        char ch = Character.toUpperCase(s.charAt(0));
        result.append(ch);
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == ' ' && i<s.length()-1){
                
                result.append(s.charAt(i));
                i++;
                result.append(Character.toUpperCase(s.charAt(i)));
            }else{
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}