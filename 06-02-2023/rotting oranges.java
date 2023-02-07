class Solution {
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int t=2;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2){
                    dfs(i,j,grid,t);
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
                t = Math.max(t,grid[i][j]);
            }
        }
        return t-2;
    }
    public void dfs(int r, int c, int[][] grid, int t){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0||1<grid[r][c]&& grid[r][c]<t)
            return;
        grid[r][c]=t;
        for(int i=0; i<4; i++) {
            dfs(r+d[i][0], c+d[i][1], grid, t+1);
        }
    }
}