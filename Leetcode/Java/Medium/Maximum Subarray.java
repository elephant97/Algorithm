class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = nums[0];
        int max = nums[0];
        if (length == 1)
            return nums[0];

        for (int i = 1; i < length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            sum = Math.max(sum, max);
            
        }

        return sum;
    }
}
