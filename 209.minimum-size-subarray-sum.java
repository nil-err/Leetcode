class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0x3f3f3f3f;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r ++){
            sum += nums[r];
            while(sum >= target){
                int subLen = r - l + 1;
                res = Math.min(res, subLen);
                sum -= nums[l++];
            }
        }
        return res == 0x3f3f3f3f ? 0 : res;
    }
}
