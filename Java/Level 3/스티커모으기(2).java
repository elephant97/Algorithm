class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        // 예외 처리: 스티커가 3개인 경우 까지일 단순히 max 비교로 값 구할 수 있음
        if (n == 1) return sticker[0];
        else if(n == 2) return Math.max(sticker[0], sticker[1]);
        else if(n == 3) return Math.max(sticker[0], Math.max(sticker[1],sticker[2]));

        // 첫 번째 스티커를 뜯는 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }


        // 마지막 스티커를 뜯는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;  // 첫 번째 스티커는 뜯을 수 없음
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        // 두 경우 중에서 최대값을 선택
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
