import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int posA = A.length-1;
        int posB = B.length-1;
        
        Arrays.sort(A);
        Arrays.sort(B);

        while(posB >= 0 && posA >= 0){
            int valueA = A[posA];
            int valueB = B[posB];

            if(valueA < valueB){
                posA--;
                posB--;
                answer++;
                continue;
            }
            
            posA--; //B는 이길 수 있을 때 까지 찾아야 하기 때문에 A의 위치만을 옮김
        }

        return answer;
    }
}
