class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o1[1], o2[1]);
            }
        });
        int res = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= points[i-1][1]){
                points[i-1][0] = points[i][0];
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }else{
                res ++;
            }
        }
        return res;
    }
}
