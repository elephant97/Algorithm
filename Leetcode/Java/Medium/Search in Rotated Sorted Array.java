class Solution {
    public int search(int[] nums, int target) {
        int numsLength = nums.length;
        int start = 0;
        int end = numsLength-1;
        int ans = -1;

        if(numsLength == 1){
            return nums[0] == target? 0 : -1;
        }

        while(end - start > 0){            
            int half = (end - start) / 2;

            if(nums[half] == target){
                ans = half;
                break;
            }
            if(nums[start] == target){
                ans = start;
                break;
            }
            if(nums[end] == target){
                ans = end;
                break;
            }

            if(nums[start] <= target && nums[start+half] >= target){
                end = start+half;
            }else if(nums[start+half+1] <= target && nums[end] >= target){
                start = start+half+1;
            }else{
                if(nums[half+start] >= target && nums[end] >= target){
                    if(nums[end] - target < nums[half+start] - target){
                        start = half+start+1;
                    }else{
                        end = start+half;
                    }
                }else {
                    if(target - nums[start] > target - nums[start+half+1]){
                        start = start+half+1;
                    }else{
                        end = start+half;
                    }
                }

                if(end > numsLength-1) end = numsLength-1;
               
            }
        }

        return ans;
    }
}
