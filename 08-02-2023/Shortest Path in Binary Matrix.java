class Solution {
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,-1}, {-1,1}, {1,1}, {-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        if(grid[0][0]==1 || grid[grid.length-1][grid.length-1]==1)
            return -1;
        if(grid.length==1&&grid[0][0]==0)
            return 1;
        int len = 1;
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0]=true;
        queue.add(new int[] {0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] curr = queue.poll();
                for(int i=0; i<d.length; i++){
                    int nx = curr[0]+d[i][0];
                    int ny = curr[1]+d[i][1];
                    if(nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length&&grid[nx][ny]==0&&visited[nx][ny]==false){
                        if(nx==grid.length-1 && ny==grid[0].length-1){
                            len++;
                            return len;
                        }
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            len++;
        }
        return -1;
    }
}