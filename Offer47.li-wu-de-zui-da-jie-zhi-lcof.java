class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int cloum = grid[0].length;
        int[][] dp = new int[row+1][cloum+1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= cloum; j++){
                dp[i][j] = Math.max(dp[i-1][j] + grid[i-1][j-1], dp[i][j-1] + grid[i-1][j-1]);
            }
        }
        return dp[row][cloum];
    }
}
