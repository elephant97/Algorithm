class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean visited[]  = new boolean[nums.length];
        
        permutations(nums, new ArrayList<>(), visited);

        return answer;
    }

    void permutations(int[] nums, List<Integer> bucket, boolean visited[]){
        
        if(bucket.size() == nums.length){
            answer.add(bucket);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                bucket.add(nums[i]);
                visited[i] =true;
                permutations(nums, new ArrayList<>(bucket),visited);
                visited[i] =false;
                bucket.remove(bucket.size()-1);
            }
        }
    }

}
