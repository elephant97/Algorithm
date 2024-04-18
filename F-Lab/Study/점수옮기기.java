class Solution {
    
    public int changeScore(int cap, int k, int[] score, int m) {
        Stack<Integer> over = new Stack<>();
        Stack<Integer> under = new Stack<>();
        int answer = -1;


        for(int i = 0; i < score.length; i++){
            if(score[i] > k){
                over.push(score[i]);
            }else{
                under.push(score[i]);
            }
        }

        if(over.size() == 0) return 0;
        if(under.size() == 0) return -1;

        int overPeek = over.pop();
        int underPeek = under.pop();
        int count = 2;

        while(true){
            int calc = Math.min(overPeek-k, k-underPeek);

            if(overPeek-calc > k){
                overPeek -= calc;
            }else{
                if(over.size() == 0) break;
                if(over.size() < m){
                    answer = count;
                    break;
                } 
                overPeek = over.pop();
                count++;
            }

            if(underPeek+calc < k){
                underPeek += calc;
            }else{
                if(under.size() == 0) break;
                underPeek = under.pop();
                count++;
            }
        }

        return answer;
    }

}
