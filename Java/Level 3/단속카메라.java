import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001; // 진입시점의 최소점보다 낮은 수로 초기화
        
        // 끝나는 지점 기준으로 정렬
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));
        
        for(int i = 0; i < routes.length; i++){      
            if(camera < routes[i][0]){ //카메라 위치가 진입시점보다 크면 만날 수 없으므로 카운팅
                camera = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
    
}
