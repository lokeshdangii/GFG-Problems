//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int arr[] = new int[V]; int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0;i<V;i++){
            hm.put(i,0);
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                hm.put(adj.get(i).get(j), hm.getOrDefault(adj.get(i).get(j), 0)+1);
            }
        }
        
        for(int i=0;i<V;i++){
            if(hm.get(i) == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int key = q.poll();
            arr[idx] = key;
            idx++;
            
            for(int i=0;i<adj.get(key).size();i++){
                int node = adj.get(key).get(i);
                hm.put(node, hm.get(node)-1);
                
                
                if(hm.get(node) == 0){
                    q.add(node);
                }
            }
            
        }
        
        return arr;
    }
}
