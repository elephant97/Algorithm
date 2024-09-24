class Solution {
    public String countAndSay(int n) {
        StringBuilder answer = new StringBuilder("1");

        if(n == 1) return answer.toString();

        for(int i = 1; i < n; i++){
            answer = stringCount(answer.toString());
        }
        
        return answer.toString();
    }

    StringBuilder stringCount(String target){
        StringBuilder newTarget = new StringBuilder();
        char diffChar = target.charAt(0);
        int count = 1;

        for(int i = 1; i < target.length(); i++){
            if(target.charAt(i) != diffChar){
                newTarget.append(Integer.toString(count)).append(diffChar);
                diffChar = target.charAt(i);
                count = 1;
            }else{
                count++;
            }
        }

        newTarget.append(Integer.toString(count)).append(diffChar);

        return newTarget;
    }
}
