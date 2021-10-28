class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        int pre = nums[0];
        for(int i = 1; i < len; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            result = Math.max(pre, result);
        }
        return result;
    }
}
