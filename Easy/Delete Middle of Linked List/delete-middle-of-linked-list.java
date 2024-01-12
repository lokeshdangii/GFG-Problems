//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
    } 
} 
   

// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    
    //     function to get size of LL
    public int get_Length(Node head){
        
        if(head == null){
            return 0;
        }

        int count = 0;
        Node tmp = head;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        int len = get_Length(head);
        int mid = (int) (len/2);
        
        if(len == 1){
            head = null;
            return head;
                
        }
        
        if(len == 2){
            head.next = null;
            return head;
        }
        Node tmp = head;
        for(int i=1;i<mid;i++){
            tmp = tmp.next;
        }
        
        tmp.next = tmp.next.next;
        
        return head;
    }
}