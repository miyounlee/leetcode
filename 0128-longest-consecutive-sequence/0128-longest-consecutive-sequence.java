class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            numsSet.add(i);
        }
        int logest = 0;

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i] + 1;
            int count = 1;
            if (!numsSet.contains(nums[i] - 1)) {
                while (numsSet.contains(next)) {
                    count++;
                    next++;
                }
            }
            logest = Math.max(logest, count);
        }
        return logest;
    }
}