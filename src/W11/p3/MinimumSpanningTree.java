package W11.p3;

import java.util.Arrays;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int[][] castles = {
                {0, 1, 2, 8},
                {1, 0, 3, 5},
                {2, 3, 0, 4},
                {8, 5, 4, 0}
        };

        System.out.println(minimumSpanningTree(castles));
    }

    private static int minimumSpanningTree(int[][] nodes) {
        int n = nodes.length;
        int length = 0;

        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        int nodeCount = 0;
        while (nodeCount < n) {
            int shortest = Integer.MAX_VALUE;
            int shortestNode = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            if (shortest == Integer.MAX_VALUE) {
                return shortest;
            }

            visited[shortestNode] = true;
            length += distances[shortestNode];
            nodeCount++;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (nodes[shortestNode][i] <= 0) {
                    continue;
                }
                if (distances[i] > nodes[shortestNode][i]) {
                    distances[i] = nodes[shortestNode][i];
                }
            }
        }
        return length;
    }
}
