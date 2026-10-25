class Solution {
        public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (char c : s1) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        for (char c : t1) {

            if (!map.containsKey(c)) return false;
            map.compute(c, (k, v) -> (v == 1) ? null : v - 1);
        }

        return map.isEmpty();
    }
}
