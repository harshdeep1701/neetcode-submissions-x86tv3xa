class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            char[] arr = strs.get(i).toCharArray();
            for(char c:arr) {
                builder.append(convertCharInto3DigitInt(c));
            }
            if(i<strs.size()-1) {
                builder.append(",");
            }
        }
        return strs.size()>0 ? builder.toString() : null;
    }

    public List<String> decode(String str) {
        if(str == null) {
            return new ArrayList();
        }
        String[] encodedList = str.split(",", -1);
        List<String> result = new ArrayList();
        for(String encodedStr: encodedList) {
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<encodedStr.length();) {
                int value = Integer.valueOf(encodedStr.substring(i, Math.min(i + 3, encodedStr.length())));
                builder.append((char) value);
                i+=3;
            }
            result.add(builder.toString());
        }
        return result;
    }

    String convertCharInto3DigitInt(char c) {
        int encodedInt = (int) c;
        String value = "";
        int counter = 0;
        while(encodedInt != 0 || counter < 3) {
            value = new String("" + encodedInt % 10) + (value);
            encodedInt = encodedInt / 10;
            counter++;
        }
        return value;
    }
}
