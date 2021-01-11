package Algorithm.Java.StringAndArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
# Question09. K Closest Points to Origin(PriorityQueue)
    Eng: We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
         (Here, the distance between two points on a plane is the Euclidean distance.)
         You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
    Kor: 우리는 비행기의 포인트 목록을 가지고 있습니다. 원점(0, 0)에 가장 가까운 K 점을 찾으세요.
         (여기서, 평면상의 두 점 사이의 거리는 유클리드 거리이다.)
         당신은 어떤 순서로든 답신을 할 수 있습니다. 답은 고유한 것이 보장됩니다(순서는 제외).

    input: points = [[1,3], [-2,2]], K=1
    output: [[-2,2]]

    Explanation: The distance between (1, 3) and the origin is sqrt(10).
                 The distance between (-2, 2) and the origin is sqrt(8).
                 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.\
                 We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class T08_KClosestPointsToOrigin {

    public static void main(String[] args) {
        T08_KClosestPointsToOrigin a = new T08_KClosestPointsToOrigin();
        int[][] points = {{1,3}, {-2,2}};
        int k = 1;
        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {
//        Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
        Queue<int[]> queue = new PriorityQueue<>((a,b)->((a[0]*a[0])+(a[1]*a[1]))-((b[0]*b[0])+(b[1]*b[1])));
        int[][] result = new int[k][2];
        int index = 0;

        for(int[] p: points) {
            queue.offer(p);
        }
        while(index <k) {
            result[index] = queue.poll();
            index++;
        }
        return result;

    }

    Comparator<int[]> Comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return ((a[0]*a[0])+(a[1]*a[1]))-((b[0]*b[0])+(b[1]*b[1]));
        }
    };

    public void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for(int i=0; i< result.length; i++) {
            for(int j=0; j<result[i].length; j++) {
                System.out.println(result[i][j]);
            }
            System.out.println();
        }
    }
}
