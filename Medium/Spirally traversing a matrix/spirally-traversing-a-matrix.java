//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int n, int m)
    {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        // code here 
        int startRow = 0;
        int endRow = matrix.length -1;
        int startCol = 0;
        int endCol = matrix[0].length-1;
        
        
        
        
        while(startRow <= endRow && startCol <= endCol){
            
            // top

            for(int j=startCol;j<=endCol;j++){
                result.add(matrix[startRow][j]);
            }
           
            // Right
            
            for(int i=startRow+1;i<=endRow;i++){
                result.add((matrix[i][endCol]));
            }
            
            // Bottom
            
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow == endRow){
                    break;
                }
                result.add(matrix[endRow][j]);
            }
    
            // left
            
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                break;
            }
                result.add(matrix[i][startCol]);
            }
            
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        
        return result;
    }
}
