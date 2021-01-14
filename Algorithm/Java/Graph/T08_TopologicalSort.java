package Algorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
# Question08. CourseSchedule -> 위상정렬(Topological Sort, Queue)
    DAG(Directed Acyclic Graph),i.e.there is no cycle existed in the graph.

    Kor: 코스 0을 수강하기 위해 일부 코스에는 전제조건이 있을 수 있다.
         먼저 코스 1을 수강해야 한다.
         [0,1] 총 과정 수와 전제 조건 쌍이 주어지면 모든 과정을 마칠 수 있나?

    input: [[1,0],[0,1]]
    output: false
    input: [[1,0],[2,1],[3,2]]
    output: true

 */
public class T08_TopologicalSort {

    public static void main(String[] args) {
        int course = 4;
        int[][] nums = {{1, 0},
                {2, 1},
                {3, 2}};

        int[][] nums2 = {{1, 0},
                {0, 1}};

//		int[][] nums2 = {
//				 { 1, 2 },
//		         { 3, 1 },
//		         { 2, 3 } };


        T08_TopologicalSort a = new T08_TopologicalSort();
        System.out.println(a.solve(course, nums));
    }

    public boolean solve(int courseNumber, int[][] nums) {
        if (courseNumber <= 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        // 1. inDegree : [1, 1, 1, 0]
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]]++;
        }

        // 2.queue에 0인 값 찾아서 넣기
        int completeLength = inDegree.length;
        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        // 3.
        while (!queue.isEmpty()) {
            int zeroVal = queue.poll(); // 3
            for (int i = 0; i < numsLength; i++) {
                System.out.println("=============");
                if (zeroVal == nums[i][0]) {
                    System.out.println("zeroVal " + zeroVal + " i " + i);
                    inDegree[nums[i][1]]--;
                    if (inDegree[nums[i][1]] == 0)
                        queue.offer(nums[i][1]); // 2
                }
            }
        }

        /*
         *  4. 3번에서 completed에 값을 0으로 다 만들어야
         *  완성completed[nums[i][1]]--
         */

        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }
}
