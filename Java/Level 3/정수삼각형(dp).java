import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        int triangleLastRow = 0;
        dp[0][0] =  triangle[0][0]; //맨 윗층은 더할 것이 없으므로 그냥 대입한다.
        
        for(int i = 1; i < triangle.length; i++) //행의 이동
        {
            //첫번째 열
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            
           
            for(int j = 1; j < i; j++) // 중간 열 (열 이동)
            {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
            
            //마지막 열
            dp[i][i] = triangle[i][i] + dp[i-1][i-1]; //dp는 윗줄 계산이므로 현재 행 보다 하나가 더 적음 
        }
        
        
        //처음에는 퀵정렬을 사용해서 정답을 추출했지만, 
        //퀵정렬은 O(n log n)의 시간 복잡도를 가지므로 큰 배열에서는 더 많은 비용 소모로
        //아래와같이 변경
        // Arrays.sort(dp[triangle.length-1]); 
        // answer = dp[triangle.length-1][triangle.length-1];
        
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        
        return answer;
    }
}

