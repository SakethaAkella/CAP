class Solution {
   
    public boolean canFinish(int num, int[][] pre) {
        int visited[] = new int[num];
        List<List<Integer>> graph = new ArrayList<List<Integer>>(num);
        for(int i=0; i<num; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<pre.length; i++) {
            graph.get(pre[i][0]).add(pre[i][1]);
        }
        
        for(int i=0; i<num; i++) {
            if(!dfs(graph, visited, i)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> graph, int visited[], int vertex) {
        visited[vertex] = 1;
        
        List<Integer> adj = graph.get(vertex);
        for(int i=0; i<adj.size(); i++) {
            int toVisit = adj.get(i);
            if(visited[toVisit] == 1) return false;
            if(visited[toVisit] == 0) {
                 if(!dfs(graph, visited, toVisit)) return false;
            }
        }
        
        visited[vertex] = 2;
        return true;
    }
}