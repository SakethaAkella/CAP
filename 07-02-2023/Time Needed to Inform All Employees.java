class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            if(manager[i]!=-1){
                graph[manager[i]].add(i);
            }
        }
        return dfs(graph, headID, informTime);
    }
    public int dfs(List<Integer>[] graph, int curr, int[] informTime){
        int res = 0;
        for(int emp: graph[curr]){
            res = Math.max(res,dfs(graph,emp,informTime));
        }
        return res+informTime[curr];
    }
}