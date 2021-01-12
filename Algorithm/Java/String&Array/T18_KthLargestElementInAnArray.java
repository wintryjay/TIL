package Algorithm.Java.StringAndArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
# Question19. Kth Largest Element In An Array(priorityQueue (Array, Sort, PriorityQueue)
    Eng: Find the kth largest element in an unsorted array.
         Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Kor: 정렬되지 않은 배열에서 k번째 가장 큰 요소를 찾습니다. 이 요소는 k번째 고유 요소가 아니라 정렬된 순서대로 k번째 가장 큰 요소입니다.

    input:
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
    output: 5

    ## Solutions) 2가
    1. 배열 오름차순 {1,2,3,4,5,6} 6-2=4
    2. PriorityQueue, k = 2
 */
public class T18_KthLargestElementInAnArray {

    public static void main(String[] args) {
        T18_KthLargestElementInAnArray a = new T18_KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(a.solve_array(nums, k));
        System.out.println(a.solve_pq(nums, k));
    }

    public int solve_array(int[] nums, int k) {
        int length= nums.length; // 6
        Arrays.sort(nums);
        return nums[length-k];
    }

    public int solve_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comp);

        for(int val: nums) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek(); // peek() :: Retrieves, but does not remove. :: 큐의 맨 위에 있는 것을 반환
    }

    Comparator<Integer> Comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a-b;
        }
    };

    public void print(int[] nums) {
        for(int i:nums)
            System.out.println("i :" + i);
    }
}
