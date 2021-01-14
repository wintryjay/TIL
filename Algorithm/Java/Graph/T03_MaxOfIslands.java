package Algorithm.Graph;
/*
# Question03. Max of Islands(DFS)
    Eng:
    Kor: 1은 육지, 0은 바다 인데 이중 가장 큰 육지의 크기 구하시오

    input:
        int[][] grid = {
                {'1','1','0','1','1'},
                {'0','1','1','0','0'},
                {'0','0','0','0','0'},
                {'1','1','0','1','1'},
                {'1','0','1','1','1'},
                {'1','0','1','1','1'}
                };
    output: 8

    ## Solution)
    1. Number of Island , 섬의 개수를 구한다.
    2. count 변수를 두고, 크기를 4, 2, 4, 8 중 Max= Math.max(max, area);

 */

public class T03_MaxOfIslands {

    public static void main(String[] args) {

        int[][] grid = {
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1}
        };
        T03_MaxOfIslands a = new T03_MaxOfIslands();
        System.out.println(a.maxAreaOfIsland(grid));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        // 1.
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
//        System.out.println(m);
        n = grid[0].length;
//        System.out.println(n);

        int max = 0;

        // 2.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    System.out.println("area " +area);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int x, int y, int area) {
        // 1. dfs 탈출
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y] == 0) return area;

        // 2. 값이 1인 육지가 들어오는 경우
        grid[x][y]=0;
        area++;
        for(int[] dir : dirs) {
            area = dfs(grid, x+dir[0], y+dir[1], area);
        }
        return area;
    }

}
