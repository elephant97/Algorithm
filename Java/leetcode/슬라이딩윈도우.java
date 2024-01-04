import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // k 범위의 시작 부분을 넘어간 인덱스를 제거
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // 새로운 요소가 현재 위치의 최대값보다 크면 이전 요소들 제거
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 인덱스 추가
            deque.offer(i);

            // 배열에 최대값 추가
            if (i >= k - 1) {
                answer[i - k + 1] = nums[deque.peek()];
            }
        }

        return answer;
    }
}
