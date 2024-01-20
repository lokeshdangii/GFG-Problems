//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends


class Queue
{
    Stack<Integer> s1 = new Stack<Integer>(); 
    Stack<Integer> s2 = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
	    return s1.pop();
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    // Emptying Stack s1
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        // pushing s2 elements in s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }	
    }
}

