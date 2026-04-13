class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map, List<String>> mapOfMaps = new HashMap();
        for(int i=0;i<strs.length;i++) {
            Map<Character, Integer> strMap = getCharcterLengthMap(strs[i]);
            mapOfMaps.putIfAbsent(strMap, new ArrayList());
            mapOfMaps.get(strMap).add(strs[i]);
        }
        return new ArrayList(mapOfMaps.values());
    }

    public Map<Character, Integer> getCharcterLengthMap(String str) {
        Map<Character, Integer> charMap = new HashMap();
        for(Character c:str.toCharArray()) {
            if(charMap.containsKey(c)) {
                charMap.replace(c, charMap.get(c)+1);
            } else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }
}
