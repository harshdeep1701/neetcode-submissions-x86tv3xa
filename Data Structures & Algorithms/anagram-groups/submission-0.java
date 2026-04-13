class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map, String> mapOfMaps = new HashMap();
        for(int i=0;i<strs.length;i++) {
            Map<Character, Integer> strMap = getCharcterLengthMap(strs[i]);
            if(mapOfMaps.containsKey(strMap)) {
                mapOfMaps.replace(strMap, (mapOfMaps.get(strMap)+","+i));
            } else {
                mapOfMaps.put(strMap, i+"");
            }
        }
        List<List<String>> result = new ArrayList();
        mapOfMaps.forEach((key, value) -> {
            List<String> anagramList = new ArrayList();
            String[] indexes = value.split(",");
            for(String i:indexes) {
                anagramList.add(strs[Integer.valueOf(i)]);
            }
            result.add(anagramList);
        });
        return result;
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
