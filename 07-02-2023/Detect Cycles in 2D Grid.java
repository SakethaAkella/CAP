class Solution {
    int[][] d = {{0,-1},{-1,0},{1,0},{0,1}};
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!visited[i][j]){
                    if(cycle(grid, i, j, visited, -1, -1))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean cycle(char[][] grid, int x, int y, boolean[][] visited, int px, int py){
        visited[x][y]=true;
        for(int i=0; i<4; i++){
            int nx = x+d[i][0];
            int ny = y+d[i][1];
            if(nx<0 || nx>=grid.length || ny<0 || ny>=grid[0].length || grid[nx][ny]!=grid[x][y])
                continue;
            if(nx == px && ny == py)
                continue;
            if(visited[nx][ny])
               return true;
            if(cycle(grid, nx, ny, visited, x, y))
                return true;
        }
        return false;
    }
}