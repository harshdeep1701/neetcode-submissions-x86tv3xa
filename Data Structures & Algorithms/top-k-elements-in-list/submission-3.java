class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap();
        for(int i:nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        
        for(int i=0; i<nums.length+1; i++) {
            bucket[i] = new ArrayList();
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            int freq = entry.getValue();
            int number = entry.getKey();
            bucket[freq].add(number);
        }

        int counter = 0;
        int[] result = new int[k];

        for(int i=nums.length; i>=1 && counter<k; i--) {
            for(int n:bucket[i]) {
                result[counter++] = n;
            }     
        }
        return result; 
    }
}
