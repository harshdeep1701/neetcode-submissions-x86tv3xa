class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap();
        for(int i=0;i<nums.length;i++) {
            int diff = target-nums[i];
            if(diffMap.containsKey(nums[i])) {
                return new int[]{diffMap.get(nums[i]),i};
            }
            diffMap.put(diff, i);
        };
        return new int[]{0,0};
    }
}
