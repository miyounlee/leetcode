// Top-Down
class Solution {
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    public int dp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else if (memo[n] == -1) {
            memo[n] = dp(n - 1) + dp(n - 2);
        }
        return memo[n];

    }
}