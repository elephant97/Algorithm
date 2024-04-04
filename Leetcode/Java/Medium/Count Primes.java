class Solution {
    public static int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        if(n<2)return 0;
        
        // 에라토스테네스의 체 알고리즘 적용
        for (int i = 2; i * i < n; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        // 소수 개수 세기
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) primeCount++;
        }
        
        return primeCount;
    }
}

