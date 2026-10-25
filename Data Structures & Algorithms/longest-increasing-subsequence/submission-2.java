class Solution {
    static Integer[][] memo;

    public static int lengthOfLIS(int[] nums) {
       int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        // Tính dp bottom-up
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);

            // Debug log
            System.out.println("i=" + i + ", nums[i]=" + nums[i] +
                    ", dp[i]=" + dp[i]);
        }

        // In ra dp cuối cùng để quan sát
        System.out.println("DP array: " + java.util.Arrays.toString(dp));
        return maxLen;
    }

}
