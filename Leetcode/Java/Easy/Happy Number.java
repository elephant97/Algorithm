class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        int sum = Integer.MAX_VALUE;
        Set<Integer> cycle = new HashSet<>();

        while(true){
            int quotient = temp;
            sum = 0;
            while(quotient != 0){
                sum += Math.pow(quotient % 10, 2);
                quotient = quotient / 10;
            }
            temp = sum;

            if(sum < 10){
                if(sum == 1 || cycle.contains(sum)) break;
                cycle.add(sum);
            }
        }

        return sum == 1 ? true : false;
    }
}
