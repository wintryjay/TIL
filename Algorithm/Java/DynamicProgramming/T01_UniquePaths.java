package Algorithm.DynamicProgramming;
/*
# Question01. Unique Paths(DP, 재사용_
    Eng: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
         The robot can only move either down or right at any point in time.
         The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
         How many possible unique paths are there?
    Kor: 로봇은 m x n 그리드의 왼쪽 상단 모서리에 있습니다(아래 다이어그램에서 '시작'으로 표시됨).
         로봇은 한 번에 아래로 또는 오른쪽으로만 이동할 수 있습니다. 로봇이 그리드의 오른쪽 하단 모서리에 도달하려고 합니다
         (아래 다이어그램에 '마침'으로 표시됨).
         가능한 고유 경로가 몇 개 있습니까?

    input: m =7, n=3
    output: 28
 */
public class T01_UniquePaths {

    public static void main(String[] args) {
        int m =7, n=3;
        System.out.println(uniquePaths(m, n));
    }
    public static int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){

                map[i][j] = map[i-1][j]+map[i][j-1];
                System.out.println("map["+i+"]["+j+"] "+map[i][j]);
            }
        }
        return map[m-1][n-1];
    }
}
