class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = Arrays.toString(chars);
            
            if (map.containsKey(sortedStr)) {
                List<String> r = map.get(sortedStr);
                r.add(str);
                map.put(sortedStr, r);
            } else {
                List<String> r = new ArrayList<>();
                r.add(str);
                map.put(sortedStr, r);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}
