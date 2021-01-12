package Algorithm.Java.StringAndArray;
/*
# Question 13. MaximumSubarray
    Eng: Given an integer array nums, find the contiguous subarray (containing at least one number)
         which has the largest sum and return its sum.
    Kor: 정수 배열 번호가 지정된 경우 연속된 하위 배열(하나 이상의 숫자를 포함)을 찾습니다. 합계가 가장 큰 구간 값이 반환됩니다.
         Subarray 중에 합이 제일 큰 수, 1 두 개의 , 2 nums[i]

    input: int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
    output:
 */
public class T12_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // 1.
        int newSum = nums[0];
        int max = nums[0];

        // 2.
        for(int i=1; i<nums.length; i++) {
            newSum = Math.max(nums[i], newSum+nums[i]);
            max = Math.max(newSum, max);
        }
        return max;
    }
}
