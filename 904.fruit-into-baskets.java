class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int count = 0;
        int res = 0;
        for(int r = 0; r < fruits.length; r ++){
            if(map.getOrDefault(fruits[r], 0) == 0){
                count ++;
            }
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(count >= 3){
                if(map.getOrDefault(fruits[l], 0) == 1){
                    count --;
                }
                map.put(fruits[l], map.get(fruits[l]) - 1);
                l ++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
