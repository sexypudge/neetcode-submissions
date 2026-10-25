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

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));

        //
        //            if (heap.size() > k) {
        //                heap.poll();
        //            }
        heap.addAll(map.keySet());

        for (int i = k - 1; i >= 0 ; i--) {
            if (!heap.isEmpty()) {
                result[i] = heap.poll();
            }
        }

        return result;
    }
}
