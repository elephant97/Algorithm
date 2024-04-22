class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
       
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            String s = Long.toBinaryString(n);
            int len = s.length(), depth = 1, cnt = 1;
           
            while (len > cnt) {
                depth *= 2;
                cnt += depth;
            }
           
            s = "0".repeat(cnt - len) + s;
           
            answer[i] = isValid(s.toCharArray(), 0, s.length() - 1, false) ? 1 : 0;
        }
       
        return answer;
    }
   
    private boolean isValid(char[] arr, int l, int r, boolean shouldBeZero) {
        int mid = l + (r - l) / 2;
        if (shouldBeZero && arr[mid] != '0') return false;
        if (l == r) return true;
       
        boolean isZero = arr[mid] == '0';
       
        return isValid(arr, l, mid - 1, isZero) && isValid(arr, mid + 1, r, isZero);
    }
}
