class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i : nums) {
            numsSet.add(i);
        }
        int logest = 0;
        for (int i : nums) {
            int next = i + 1;
            int count = 1;
            if (!numsSet.contains(i - 1)) {
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