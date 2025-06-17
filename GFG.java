import java.util.*;

public class GfG {
    
    public static void
    addEdge(ArrayList<ArrayList<Integer> > adj, int s,
            int t)
    {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    
    private static void
    dfsRec(ArrayList<ArrayList<Integer> > adj,
           boolean[] visited, int s, ArrayList<Integer> res)
    {
        visited[s] = true;
        res.add(s);

                for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }
    }

        public static ArrayList<Integer>
    DFS(ArrayList<ArrayList<Integer> > adj)
    {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();

        
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        int V = 6;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

                int[][] edges
            = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

                ArrayList<Integer> res = DFS(adj);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
