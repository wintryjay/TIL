package Algorithm.Graph;

/*
# Question07. Maze(DFS, Visitedm new point)
    Eng:
    Kor:

    input:
        start = (0,4)
        destination = (4,4)
    output:
        true;

    ## solution)
    1. 벽면 인식 후, 벽 앞 위치 (공이라고 생각하고, 팅겨나오는 걸 생각)
    2. new point
 */
public class T07_MazeDFS {

    public static void main(String[] args) {

        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {4, 4};
//        int[] dest = {3, 2};
        T07_MazeDFS a = new T07_MazeDFS();
        System.out.println(a.hasPath(maze, start, dest));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length; //5
        n = maze[0].length; //5
        boolean[][] visited = new boolean[m][n];
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        System.out.println(
                "#########start x: " + start[0] + " y: " + start[1] + " visited " + visited[start[0]][start[1]]);
        //
        if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]])
            return false;

        visited[start[0]][start[1]] = true;
        print(visited);
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        //
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            System.out.println("11 x: " + x + " y: " + y);
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) { // 해당 조건 애들만 들어와서 작동할 수 있음
                x += dir[0];
                y += dir[1];
                System.out.println("22 x: " + x + " y: " + y + " " + dir[0] + " " + dir[1]);

            }
            x -= dir[0];
            y -= dir[1];
            System.out.println("new int x: " + x + " y: " + y);

            //
            if (dfs(maze, new int[] {x, y}, destination, visited)) {
                return true;
            }
            System.out.println();
        }

        return false;
    }

    private void print(boolean[][] visited) {
        if (visited == null || visited.length == 0)
            return;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
