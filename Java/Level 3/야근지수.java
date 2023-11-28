import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer=0;
        int sum=0;
        //우선순위 큐를 사용하여 자동으로 정렬되도록 함
        PriorityQueue<Integer> workQueue = new PriorityQueue<>(Collections.reverseOrder()); //큰 숫자가 먼저 나오도록 
        for(int task : works){
            workQueue.add(task);
            sum += task;
        }
        
        if(sum <= n)
            return 0;
        
        int task;
        for(int i = 0; i < n; i++){
            task = workQueue.poll();
            if(task -1 != 0)
                workQueue.offer(task -1);
        }
        
        if(workQueue.size() == 0)
            return 0;
       
        while(!workQueue.isEmpty())
        {
            answer += Math.pow(workQueue.poll(),2);
        }
        
            
        return answer;
    }
}
