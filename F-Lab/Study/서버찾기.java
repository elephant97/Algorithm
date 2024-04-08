import java.util.*;

class Solution {
    
    int count;
    int limitDrainage;
    double limitMilliSec;
    int[][] delays;

    public int[] algorithm(int[][] delays, int[] limits) {
        limitDrainage = limits[0];
        limitMilliSec = limits[1]*1000;
        int personnel = delays[0].length;
        count = delays.length-1;
        this.delays = delays;
        int[] answer = new int[]{-1, 0};

        for(int i = 0; i < personnel; i++){
            final int diff = i;
            Arrays.sort(delays, (a, b) -> a[diff] - b[diff]);
            int findCount = find(i, 0, count);
            // System.out.println(findCount); 
            if(findCount != -1 && answer[0] < findCount){
                answer[0] = findCount;
                answer[1] = i+1;
            }
        }

        return answer;
    }

    public int find(int i, int min, int max){
        
        if(min >= max) return -1;
        
        if(delays[max][i]-delays[min][i] < limitMilliSec &&
            delays[max][i] < delays[min][i]*limitDrainage){
            // System.out.println(""+delays[min][i]+ ":" +delays[max][i]);
            return max-min+1;
        }
        
        return Math.max(find(i, min+1, max), find(i, min, max-1));
    } 

}
