class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> answerLists = new ArrayList<>();
        
        


        // for(int i = 0; i < (nums.length-1)/ 2 -1; i++)
        // {  
            int left = 0;
            int right = nums.length-1;
            int leftMove = 1;
            int rightMove = 1;  
            while(left+leftMove < right-rightMove){
                int sum = nums[left]+nums[left+leftMove]+nums[right-rightMove]+nums[right];

                if(target == sum){
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(nums[left]);
                    sumList.add(nums[left+leftMove]);
                    sumList.add(nums[right-rightMove]);
                    sumList.add(nums[right]);
                    answerLists.add(sumList);
                    leftMove++;
                    rightMove++;
                }else if(target > sum){
                    right--;
                }else{
                    left++;
                }
            }
        // }
        return answerLists;
    }
}
