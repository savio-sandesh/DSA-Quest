class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1, target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
