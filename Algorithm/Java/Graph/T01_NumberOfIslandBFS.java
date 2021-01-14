package Algorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
# Question01. Number Of Island(BFS)
        Eng: Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
        You may assume all four edges of the grid are all surrounded by water.

        Kor: 1(토지)과 0(물)의 m x n 2d 그리드 맵이 주어진 경우, 섬 수를 반환합니다.
        섬은 물로 둘러싸여 있으며 인접한 땅을 수평 또는 수직으로 연결하여 형성됩니다.
        그리드의 네 모서리가 모두 물로 둘러싸여 있다고 가정할 수 있습니다.

        Input:
         grid = {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'},
                {'0','0','0','0','1'}
                }
        Output: 3
 */
public class T01_NumberOfIslandBFS {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };


        T01_NumberOfIslandBFS a = new T01_NumberOfIslandBFS();
        System.out.println(a.solve(grid));
    }

    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y}); // queue에 (0,0) 넣음
        while (!queue.isEmpty()) {

            int[] point = queue.poll();

            for (int[] dir : dirs) {
                // 사방으로 들어감
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[]{x1, y1});
                }
            }

        }
    }
}
