import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] splitToday = today.split("\\.");
        int year = Integer.parseInt(splitToday[0]);
        int month = Integer.parseInt(splitToday[1]);
        int day = Integer.parseInt(splitToday[2]);
        
        HashMap<String, Integer> termMap = new HashMap<>();

        for(int i = 0; i < terms.length; i++){
            String[] temp = terms[i].split(" ");
            termMap.put(temp[0], Integer.parseInt(temp[1])*28);
        }

        for(int i = 0; i < privacies.length; i++){

            String[] temp = privacies[i].split(" ");
            String[] dateTemp = temp[0].split("\\.");
            int tempMonth = Integer.parseInt(dateTemp[1]);
            int tempYears = Integer.parseInt(dateTemp[0]);
            int tempDay = Integer.parseInt(dateTemp[2])+ termMap.get(temp[1])-2;
            int addMonth = tempDay/28;
            tempDay = tempDay%28+1;
            tempMonth+=addMonth;
            if(tempMonth > 12){
                tempYears += tempMonth/ 12;
                tempMonth = tempMonth%12;
                if(tempMonth == 0){
                    tempMonth = 12;
                    tempYears--;
                }
            }
      
            
            if(tempYears < year || (tempYears == year && tempMonth < month) 
               || (tempYears == year && tempMonth == month && tempDay < day)){
                answer.add(i+1);
                continue;
            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
