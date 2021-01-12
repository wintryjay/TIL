package Algorithm.Java.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/*
# Qeustion16. SpiralMatrix(규칙 찾기// rowStart, rowEnd & colStart, colEnd)
    Eng: Given an m x n matrix, return all elements of the matrix in spiral order.
    Kor: m x n 행렬이 지정된 경우 행렬의 모든 요소를 나선형 순서로 반환합니다.

    input:
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    output:
        {1, 2, 3, 6, 9, 8, 7, 4, 5}
 */
public class T15_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        System.out.println(solve(matrix));
    }

    public static List<Integer> solve(int[][] matrix) {
        // 1.
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;

        int rowStart = 0;
        int rowEnd = matrix.length -1;
        int colStart = 0;
        int colEnd = matrix[0].length -1;

        // 2.
        while(rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for(int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            // down
            for(int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowStart <= rowEnd)
            // left
            for(int i = colEnd; i >= colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            // up
            if(colStart <= colEnd)
            for(int i = rowEnd; i >= rowStart; i--) {
                result.add(matrix[rowEnd][colStart]);
            }
            colStart++;
        }
        return result;
    }
}
