class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap();
        for(int i:nums) {
            freqMap.putIfAbsent(i, 0);
            freqMap.replace(i, freqMap.get(i)+1);
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = getHighestValueKey(freqMap);
            freqMap.remove(result[i]);
        }
        return result;
    }

    public int getHighestValueKey(Map<Integer, Integer> freqMap) {
        int maxValue = Integer.MIN_VALUE;
        Map.Entry<Integer, Integer> maxEntry = null;
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}
