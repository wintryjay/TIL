package Algorithm.Graph;
/*
# Question01. Number Of Island(DFS)
    Eng: Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
         An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
         You may assume all four edges of the grid are all surrounded by water.
    Kor: 1(토지)과 0(물)의 m x n 2d 그리드 맵이 주어진 경우, 섬 수를 반환합니다.
         섬은 물로 둘러싸여 있으며 인접한 땅을 수평 또는 수직으로 연결하여 형성됩니다.
         그리드의 네 모서리가 모두 물로 둘러싸여 있다고 가정할 수 있습니다.

    Input:
        grid = [
                  ["1","1","1","0","1"],
                  ["1","1","0","0","0"],
                  ["1","1","0","0","1"],
                  ["0","0","0","0","1"]
                ]
    Output: 3

    ## Solution)
    1. 좌표값 [0,0] 1인 상태이면 들어간다(점거한다). 0이면 못 들어 간다(점거하지 못한다).
    2. 더 이상 돌리지 못하면 이중 포문으로 나오게 되고, 다시 1인 좌표값을 찾는다.
    3. 1을 다시 반복
 */

public class T01_NumberOfIslandDFS {

    public static void main(String[] args) {
        char[][] grid = {
                        {'1','1','1','0','1'},
                        {'1','1','0','0','0'},
                        {'1','1','0','0','1'},
                        {'0','0','0','0','1'}
                        };

        T01_NumberOfIslandDFS a = new T01_NumberOfIslandDFS();
        System.out.println(a.solve(grid));
    }

    public  int solve(char[][] grid) {
        print(grid);

        // 1. Error managing
        if(grid == null || grid.length == 0 || grid[0].length ==0) return 0;

        // 2. [0,0] 이 1인것 부터 찾는다.
        int count=0;
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
//                    System.out.println("result count grid["+i+"]["+j+"] "+grid[i][j]);
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
//        System.out.println("=====after=====");
        print(grid);
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
//        System.out.println("i: "+i+" , j: "+j);
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] !='1' ) return; // 1이 아닌경우 못들어오게 함
        grid[i][j] = 'X'; // 1인 애들을 X로 바꿔줘라.

        // 사방으로 돌면서 1을 체크 함
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }

    public void print(char[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j< grid[i].length; j++){
//                System.out.println("grid["+i+"]["+j+"] " + grid[i][j]);
//                System.out.println(grid[i][j]);
            }
//            System.out.println();
        }
    }
}
