class Solution {
    public int getMoneyAmount(int n) {
        if(n == 1){
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }
        for(int j = 1; j < n; j++){
            for(int i = j - 1; i >= 0; i--){
                dp[i][j] = Math.min(dp[i][j], i + 1 + dp[i+1][j]);
                dp[i][j] = Math.min(dp[i][j], j + 1 + dp[i][j-1]);
                for(int k = i + 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], k + 1 + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }
        return dp[0][n-1];
    }
}
