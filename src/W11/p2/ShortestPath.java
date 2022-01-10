package W11.p2;

import java.util.Arrays;

public class ShortestPath {
    public static void main(String[] args) {
        int[][] distances = {
                {0, 3, 2, -1},
                {3, 0, -1, 5},
                {2, -1, 0, 9},
                {-1, 5, 9, 0}
        };
        System.out.println(shortestPath(distances, 0, 3));
    }

    private static int shortestPath(int[][] nodes, int src, int dest) {
        int n = nodes.length;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        boolean[] visited = new boolean[n];
//        visited[src] = true;

        int current = src;

        while (true) {
            visited[current] = true;

            int shortest = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (nodes[current][i] > 0) {
                    if (distance[i] > distance[current] + nodes[current][i]) {
                        distance[i] = distance[current] + nodes[current][i];
                    }
                }
                if (shortest > distance[i]) {
                    shortest = distance[i];
                    current = i;
                }
            }

            if (current == dest) {
                return distance[current];
            }
            if (shortest == Integer.MAX_VALUE) {
                return shortest;
            }
        }
    }
}
