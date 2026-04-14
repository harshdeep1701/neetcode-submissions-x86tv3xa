class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap();
        for(int i:nums) {
            frequencyMap.putIfAbsent(i, 0);
            frequencyMap.replace(i, frequencyMap.get(i)+1);
        }
        Map<Integer, Integer> sortedMap = 
        frequencyMap.entrySet().stream().
        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (oldValue, newValue) -> oldValue, 
                LinkedHashMap::new
            )
        );

        return sortedMap.keySet().stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
