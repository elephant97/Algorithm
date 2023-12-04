class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int i = 1;
        int j = 0;
            
        while(i <= n){
            if(j < stations.length && i >= stations[j]-w) {
                i = stations[j]+w+1;
                j++;
                continue;
            }else{
                answer++; 
                i += w*2+1;
            }
        }
        return answer;
    }
}
