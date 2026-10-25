class Solution {
    public boolean isAnagram(String s, String t) {
                    Map<Character, Integer> sMap = new HashMap<>();
                if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char c : sChars) {
            sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }


        for (char c : tChars) {
            if (sMap.get(c) == null || sMap.get(c) == 0) {
                return false;
            } else {
                sMap.put(c, sMap.get(c) - 1);
            }
        }
        
        return true;
    }
}
