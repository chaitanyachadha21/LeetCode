class Solution {

    public boolean bfs(int src , int graph[][],int visited[] , ArrayList<ArrayList<Integer>>adj)
    {
        Queue<Integer>q = new LinkedList<>();

        q.add(src);
        visited[src] = 0;

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();

            for(int i : adj.get(node))
            {
                if(visited[i] == -1)
                {
                    visited[i] = 1-visited[node];
                    q.add(i);
                }

                else if(visited[i] == visited[node])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        int visited[] = new int[graph.length];

        Arrays.fill(visited , -1);

        for(int i = 0 ; i<graph.length; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<graph.length; i++)
        {
            for(int j : graph[i])
            {
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }

        for(int i = 0; i<graph.length; i++)
        {
            if(visited[i] == -1)
            {
                if(bfs(i , graph , visited , adj)==false)
                {
                    return false;
                }
            }
        }
        return true;


    }
}