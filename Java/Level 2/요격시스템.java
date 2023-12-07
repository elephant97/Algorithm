import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        double pos = 0;
        Arrays.sort(targets, (a,b)-> Integer.compare(a[1],b[1]));
        
        for(int i = 0; i < targets.length; i++){
            if((double)targets[i][0]+0.5 > pos){
                pos = (double)targets[i][1]-0.5;
                answer++;
            }
        }
        
        return answer;
    }
}
