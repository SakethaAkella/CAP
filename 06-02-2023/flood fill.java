class Solution {
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        fill(image,sr,sc,image[sr][sc],color);
        return image;
    }
    public void fill(int[][] image, int r, int c,int clr, int color){
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=clr)
            return;
        image[r][c]=color;
        for (int i=0; i<4; i++) {
            fill(image, r+d[i][0], c+d[i][1], clr, color);
        }
    }
}