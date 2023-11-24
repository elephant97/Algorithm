import java.util.ArrayList;
import java.util.Collection;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        int max_del = 0;
        int min_del = 0;
        int list_size = 0;
        ArrayList<Integer> queue = new ArrayList<Integer>();
        
        for(int i = 0; i < operations.length; i++)
        {
            String[] splitOper = operations[i].split(" ");
            if(splitOper[0].charAt(0) == 'I')
            {
                queue.add(Integer.parseInt(splitOper[1]));
            }
            else if(!queue.isEmpty() && splitOper[0].charAt(0) == 'D')
            {
                if(splitOper[1].charAt(0) == '1')
                    queue.remove(Collections.max(queue));
                else
                    queue.remove(Collections.min(queue));
            }      
        }
        
        Collections.sort(queue);
        list_size = queue.size();
        
        if(!queue.isEmpty())
        {
            answer[0] = Collections.max(queue); 
            answer[1] = Collections.min(queue); 
        }

            
        return answer;
    }
}
