class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int i : nums) {
            if (numMap.containsKey(i)) {
                return true;
            }
            numMap.put(i, true);
        }
        return false;
    }
}