// top down
class Solution {
    int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);

        return dp(cost, cost.length);
    }

    public int dp(int[] cost, int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (memo[n] == -1) {
            memo[n] = Math.min(dp(cost, n - 1) + cost[n - 1], dp(cost, n - 2) + cost[n - 2]);
        }
        return memo[n];
    }
}