class Solution {
    public int reverse(int x) {
        int answer = 0;
        boolean firstFlag = true;
        double temp = 0;
        
        while(true){
            int quotient = x / 10;
            int remain = x % 10;
            
            if(firstFlag){
                temp = remain;
                firstFlag = false;
            }else{
                temp = temp * 10 + remain;
            }
            
            if(quotient == 0) break;
            x = quotient;
        }

        return (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) ? 0 : (int)temp;
    }
}
