class Solution {
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                int j = stack.pop();
                max = Math.max(i - j, max);
            }
        }

        return max;
    }
}
