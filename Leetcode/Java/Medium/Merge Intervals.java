class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answerBucket = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            answerBucket.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        answerBucket.add(newInterval);

        while (i < n) {
            answerBucket.add(intervals[i]);
            i++;
        }

        return answerBucket.toArray(new int[answerBucket.size()][]);
    }
}
