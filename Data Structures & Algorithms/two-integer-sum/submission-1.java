class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result =  new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
