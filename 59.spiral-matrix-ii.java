class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int curr = 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i ++){
                res[top][i] = curr ++;
            }
            for(int i = top + 1; i < bottom; i ++){
                res[i][right] = curr ++;
            }
            for(int i = right; i > left; i --){
                res[bottom][i] = curr ++;
            }
            for(int i = bottom; i > top; i --){
                res[i][left] = curr ++;
            }
            left ++;
            top ++;
            right --;
            bottom --;
        }
        return res;
    }
}
