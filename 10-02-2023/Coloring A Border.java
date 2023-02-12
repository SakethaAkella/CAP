class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        return grid;
    }
    int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    void dfs(int[][] grid,int row,int col,int con){
        grid[row][col] = -con;
        int c=0;
        for(int[] dir:dirs){
            int x = row + dir[0];
            int y = col + dir[1];
            if(x<0||y<0||x>=grid.length||y>=grid[0].length||Math.abs(grid[x][y])!=con)
                continue;
            c++;
            if(grid[x][y] != -con){
                dfs(grid,x,y,con);
            }
       }
        if(c==4)
            grid[row][col] = con;
    }
}