class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0; 
        int allSize = 0;

        for (int i = 0; i < nums.size(); i++) {
            int rowSize = nums.get(i).size();
            allSize += rowSize;
            for (int j = 0; j < rowSize; j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(0, nums.get(i).get(j));
                maxKey = Math.max(maxKey, i + j);
            }
        }

        List<Integer> result = new ArrayList<>(allSize);
        for (int key = 0; key <= maxKey; key++) {
            if (map.containsKey(key)) {
                result.addAll(map.get(key));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
