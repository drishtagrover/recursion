class Solution {
    public int combinationSum4(int[] nums, int target) {
        ArrayList<Integer> curr = new ArrayList<>();
        int[] res = new int[1];
        Integer[] memo = new Integer[target + 1];
        recur(nums, target, curr, res, memo);
        return res[0];
    }
    public int recur(int[] nums, int target, ArrayList<Integer> curr, int[] res, Integer[] memo) {
        // Base cases
        if (target < 0) return 0;
        if (target == 0) {
            res[0]++;
            return 1;
        }

        if (memo[target] != null) {
            res[0] += memo[target];  // Use memoized result
            return memo[target];
        }

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            curr.add(nums[i]);
            total += recur(nums, target - nums[i], curr, res, memo);
            curr.remove(curr.size() - 1);
        }

        memo[target] = total; // Memoize
        return total;
    }
}
