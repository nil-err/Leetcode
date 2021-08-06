class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            
        }
        for(int i = 0; i < len; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[0];
    }
}
