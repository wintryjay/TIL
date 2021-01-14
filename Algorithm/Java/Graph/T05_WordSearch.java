package Algorithm.Graph;

/*
# Question05. Word Search(DFS,
    Eng: Given an m x n board and a word, find if the word exists in the grid.
         The word can be constructed from letters of sequentially adjacent cells,
         where "adjacent" cells are horizontally or vertically neighboring.
         The same letter cell may not be used more than once.
    Kor: m x n 보드와 단어를 지정하면 단어가 그리드에 있는지 확인합니다.
         이 단어는 "인접" 셀이 수평 또는 수직으로 인접해 있는 순차적 인접 셀의 문자로 구성될 수 있습니다.
         동일한 문자 셀을 두 번 이상 사용할 수 없습니다.

    input:
        char[][] grid = {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                          };
        String word = "ABCCED";
    output: true;

    ## solution)
    1. DFS
    2. 제한 조건 찾기

 */
public class T05_WordSearch {

    public static void main(String[] args) {
        char[][] grid ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word ="ABCCEED";
        T05_WordSearch a = new T05_WordSearch();
        System.out.println(a.solve(grid, word));
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n ;
    public boolean solve(char[][] grid, String word) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return false;
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, boolean[][] visited, int x, int y ,int start, String word) {
        //1
// 		print(visited);
        if(start == word.length()) return true;
        if(x<0||x>=m || y<0||y>=n) return false; // x30 m:4
        if(visited[x][y]) return false;
        if(grid[x][y] != word.charAt(start)) return false;
        //2
        visited[x][y] =true;
        for(int[] dir: dirs) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if(dfs(grid, visited, dx,dy,start+1,word)) {
                return true;
            }
        }
        visited[x][y] =false;
        return false;

    }

    private void print(boolean[][] visited) {
        if(visited==null|| visited.length==0)return;

        int m=visited.length,n=visited[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
