class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0]=true;
        Stack<Integer> keys = new Stack();
        keys.add(0);
        while(keys.size()!=0){
            int curr = keys.pop();
            for(int room: rooms.get(curr)){
                if(!visited[room]){
                    visited[room]=true;
                    keys.add(room);
                }
            }
        }
        for(boolean i: visited){
            if(!i)
                return false;
        }
        return true;
    }
}