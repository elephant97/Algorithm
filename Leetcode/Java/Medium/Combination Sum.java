class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        getSumList(candidates, target, 0, 0, new ArrayList<>());
        
        return answer;
    }

    void getSumList(int[] candidates, int target, int sum, int start, List<Integer> buket){
        
        if(sum == target){
            answer.add(buket);
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(sum+candidates[i] > target)break;
            
            buket.add(candidates[i]);
            
            getSumList(candidates, target, sum+candidates[i], i, new ArrayList<>(buket));
            
            buket.remove(buket.size() - 1);
            
        }

        return;
    }
}
