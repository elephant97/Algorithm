class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; 
            }

            maxReach = Math.max(maxReach, i + nums[i]);
            
            if(nums.length-1 == maxReach)
                return true;
        }

        return true; 
    }

}
