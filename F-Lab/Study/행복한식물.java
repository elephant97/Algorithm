import java.util.*;

class Solution1 {
    
    public int[] happyPlant(int[] emotions, int[] orders) {
        int[] waitCycle = new int[emotions.length];
        HashMap<Integer, List<Integer>> cyclePlant = new HashMap<>();
        int badCount = 0; 
        int[] answer = new int[orders.length];
        int emotionsLength = emotions.length;

        for(int i = 0; i < emotions.length; i++){
            int cycle = emotions[i];
            if(!cyclePlant.containsKey(cycle)){
                cyclePlant.put(cycle, new LinkedList<>());
            }
            cyclePlant.get(cycle).add(i);
        }
        
        for(int i = 0; i < orders.length; i++){
            
            int plantIdx = orders[i]-1;
            
            waitCycle[plantIdx] = i+1;

            for(int j = 1; j <= i+1; j++){
                if(!cyclePlant.containsKey(j)) continue;

                List<Integer> target = cyclePlant.get(j);

                for(int k = 0; k < target.size(); k++){
                    int idx = target.get(k);
                    if(waitCycle[idx] == -1) continue;
                    
                    if(j-1 < (i - waitCycle[idx])){
                        target.remove(k);
                        waitCycle[idx] = -1;
                        k--;
                        badCount++;
                    }else if(j-1 == (i - waitCycle[idx])){
                        if(plantIdx != idx){
                            target.remove(k);
                            waitCycle[idx] = -1;
                            k--;
                            badCount++;
                        }
                    }
                }
            }

            answer[i] = emotionsLength-badCount;
        }
        
        return answer;
    }


}
