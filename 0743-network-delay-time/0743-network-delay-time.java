class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. 그래프 구현
        List<Pair>[] graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].add(new Pair(v, w));
        }
        int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        // 2. 다익스트라
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.offer(new Pair(k, 0));
        costs[k] = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            for (Pair pair : graph[current.node]) {
                int next = pair.node;
                int cost = pair.cost;
                if (costs[current.node] + cost < costs[next]) {
                    pq.offer(new Pair(next, costs[current.node] + cost));
                    costs[next] = costs[current.node] + cost;
                }
            }
        }

        int minCost = 0;
        for (int i = 1; i < n + 1; i++) {
            // 3. 방문 못한 노드 찾기
            if (costs[i] == Integer.MAX_VALUE) {
                return -1;
            }
            // 4. 최소값 중에서 최대값 구하기
            minCost = Math.max(minCost, costs[i]);
        }
        return minCost;
    }
}

class Pair {
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}