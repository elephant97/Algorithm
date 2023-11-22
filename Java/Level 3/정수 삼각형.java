class Solution {
    public int solution(int[][] triangle) {

        // 최 하단에서 부터 2가지 중 가장 큰 수와 그 윗줄의 수를 합쳐나가서 최종 맨 꼭대기의 수가 최대값이 되도록 계산
        for(int i = triangle.length-1; i > 0; i--)
        {
            for(int j = 0; j < triangle[i].length-1; j++)
            {
                triangle[i-1][j] += Math.max(triangle[i][j],triangle[i][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}
