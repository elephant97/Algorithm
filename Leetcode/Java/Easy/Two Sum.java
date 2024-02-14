class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []answer = new int[2];
        HashMap<Integer, List<Integer>> numbers = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            numbers.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i < nums.length; i++){
            List <Integer>numsIndex = numbers.get(target-nums[i]);
            if(numsIndex != null){
                for (int x : numsIndex) {
                    if (x != i) {
                        answer[0] = i;
                        answer[1] = x;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
