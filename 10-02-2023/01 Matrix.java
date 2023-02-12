class Solution {
    public int[][] updateMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> pq = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    pq.offer(new Pair(i, j));
                }else{
                    arr[i][j] = -1;
                }
            }
        }
        int[] xcor = {1,-1,0,0};
        int[] ycor = {0,0,-1,1};
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            for(int i=0;i<4;i++){
                int xtemp = xcor[i]+pair.x;
                int ytemp = ycor[i]+pair.y;
                if(xtemp >= 0 && xtemp < n && ytemp>=0 && ytemp < m && arr[xtemp][ytemp] < 0){
                    pq.offer(new Pair(xtemp, ytemp));
                    arr[xtemp][ytemp] = arr[pair.x][pair.y]+1;
                }
            }
        }
        return arr;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}