class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            if(sMap.containsKey(sarr[i])) {
                sMap.replace(sarr[i], sMap.get(sarr[i])+1);
            } else {
                sMap.putIfAbsent(sarr[i], 1);
            }

            if(tMap.containsKey(tarr[i])) {
                tMap.replace(tarr[i], tMap.get(tarr[i])+1);
            } else {
                tMap.putIfAbsent(tarr[i], 1);
            }
        }

        return sMap.equals(tMap);
    }
}
