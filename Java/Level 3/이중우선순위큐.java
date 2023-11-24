import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        int max_del = 0;
        int min_del = 0;
        int list_size = 0
        
        ArrayList<Integer> queue = new ArrayList<Integer>();//ArrayList는 크기 지정 없이 add하면 자동으로 크기가 늘어남
        
        for(int i = 0; i < operations.length; i++)
        {
            String[] splitOper = operations[i].split(" ");
            if(splitOper[0].charAt(0) == 'I') //0번째 배열에서 0번째 값을 charactor로 접근 할 때 charAt(0)으로 
            {
                queue.add(Integer.parseInt(splitOper[1]));//1번째 배열의 String 값을 인티저로 변환
            }
            else if(!queue.isEmpty() && splitOper[0].charAt(0) == 'D')
            {
                if(splitOper[1].charAt(0) == '1')
                    queue.remove(Collections.max(queue));
                else
                    queue.remove(Collections.min(queue));
            }      
        }
        
        
        if(!queue.isEmpty())
        {
            answer[0] = Collections.max(queue); 
            answer[1] = Collections.min(queue); 
        }

            
        return answer;
    }
}
