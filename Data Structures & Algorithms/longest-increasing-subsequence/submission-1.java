class Solution {
    static Integer[][] memo;

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // prevIdx có thể = -1 → dịch sang +1 để index không bị âm
        memo = new Integer[n][n + 1];
        return recursive(nums, -1, 0);
    }

    private static int recursive(int[] nums, int prevIdx, int currIdx) {
        if (currIdx == nums.length) {
            return 0;
        }

        if (memo[currIdx][prevIdx + 1] != null) {
            return memo[currIdx][prevIdx + 1];
        }

        // Option 1: bỏ qua nums[currIdx]
        int notTake = recursive(nums, prevIdx, currIdx + 1);

        // Option 2: chọn nums[currIdx] (nếu thỏa)
        int take = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            take = 1 + recursive(nums, currIdx, currIdx + 1);
        }

        return memo[currIdx][prevIdx + 1] = Math.max(take, notTake);
    }
}
