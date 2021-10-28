class Solution {
    public int translateNum(int num) {
        String src = String.valueOf(num);
        char[] nums = src.toCharArray();
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            dp[i] += dp[i-1];
            if((nums[i-2] - '0') != 0 && (nums[i-2] - '0') * 10 + (nums[i-1] - '0') < 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[len];
    }
}
