class Solution {
    public int[] solution(long begin, long end) {
        int arrayCnt = (int)(end-begin+1L);
        int[] answer = new int[arrayCnt];
        
        for(int i = 0; i < arrayCnt && begin+i <= end; i++){
            answer[i] = (int)blockValue(begin+(long)i);
        }
        return answer;
    }

    public long blockValue(long index){
        long max = (long)Integer.MIN_VALUE;
        if(index == 1L) return 0;
        
        for(long i = 2L; i <= (long)Math.sqrt(index); i++){
            if(index%i == 0){
                long temp = index/i;
                if(temp <= 10_000_000L){
                    return temp;
                }
                max = i;
            }
        }
        
        return (max != (long)Integer.MIN_VALUE)? max : 1;
    }
}
