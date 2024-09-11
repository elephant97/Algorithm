class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length-1;
        int closestSum = Integer.MAX_VALUE / 2;
        
        Arrays.sort(nums);

        for(int i = 0; i < n - 1; i++){
            int left = i + 1;
            int right = n;

            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } 
                else if (currentSum > target) {
                    right--;
                } 
                else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
