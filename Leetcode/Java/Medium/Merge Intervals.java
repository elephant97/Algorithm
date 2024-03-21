class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergeArray = new ArrayList<>();
        int x = 0;

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        mergeArray.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++){
            int[] temp = mergeArray.get(x);
            if(temp[1] >= intervals[i][0]){
                if(intervals[i][1] < temp[1]) continue;
                mergeArray.set(x, new int[]{temp[0], intervals[i][1]});
            }else{
                mergeArray.add(new int[]{intervals[i][0], intervals[i][1]}); 
                x++;   
            }
        }

        return mergeArray.stream().toArray(int[][]::new);
    }
}
