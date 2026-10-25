class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        List<Integer>[] arrLs = new List[nums.length + 1];
        for (int i = 0; i < arrLs.length; i++) {
            arrLs[i] = new ArrayList<>();
        }


        for (Integer num : map.keySet()) {
            int freq = map.get(num);
            arrLs[freq].add(num);
        }

        int count = 0;

        for (int i = arrLs.length - 1; i > 0 && count < k; i--) {
            for (int num : arrLs[i]) {
                result[count] = num;
                count++;
            }
        }

        return result;
    }
}
