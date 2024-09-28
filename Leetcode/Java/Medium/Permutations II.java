class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); 
        permute(nums, new boolean[nums.length], new ArrayList<>());
        return answer;
    }

    void permute(int[] nums, boolean[] visited, List<Integer> permuteList) {
        if (permuteList.size() == nums.length) {
            answer.add(new ArrayList<>(permuteList)); 
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            permuteList.add(nums[i]); 
            visited[i] = true; 
            permute(nums, visited, permuteList); 
            visited[i] = false; 
            permuteList.remove(permuteList.size() - 1); 
        }
    }
}
