class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) { 
            graph.add(new ArrayList<>());
        }

        for(int[] time: times) {
            graph.get(time[0] - 1).add(new int[]{time[1], time[2]});
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k - 1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int distToNode = curr[0];
            if(distToNode > distances[node]) continue;

            for(int[] neighbor : graph.get(node)){
                int newDistance = distToNode + neighbor[1];
                if(newDistance < distances[neighbor[0] - 1]){
                    distances[neighbor[0] - 1] = newDistance;
                    pq.add(new int[]{newDistance, neighbor[0] - 1});
                }
            }
        }

        int maxDistance = Integer.MIN_VALUE;
        for(int distance : distances) {
            maxDistance = Math.max(maxDistance, distance);
        }

        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}
