package Algorithm.DynamicProgramming;
/*
# Question04. Longest Increasing Subsequence
    Eng: Given an integer array nums, return the length of the longest strictly increasing subsequence.
         A subsequence is a sequence that can be derived from an array by deleting some or no elements without
         changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of
         the array [0,3,1,6,2,2,7].

    Kor: 정수 배열 숫자를 지정하면 엄격하게 증가하는 가장 긴 시퀀스의 길이를 반환합니다.
         시퀀스는 나머지 요소의 순서를 변경하지 않고 요소를 삭제하거나 삭제하여 배열에서 파생될 수 있는 시퀀스입니다.
         예를 들어 [3,6,2,7]은 배열의 연속입니다 [0,3,1,6,2,2,7].

    input:
        {1, 2, 3, 2, 5, 2, 6, 10, 4, 12};
    output:
        7


 */
import java.util.Arrays;

public class T04_LongestIncreasingSubsequence {

    public static void main(String[] args) {

        T04_LongestIncreasingSubsequence a = new T04_LongestIncreasingSubsequence();
//        int[] nums = {1,2,3, 2, 5, 2, 6, 10, 4, 12};
		int[] nums = {9,11,2,8,4,7,88,15};

        System.out.println("value "+ a.solve(nums));
    }
    public int solve(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 1;
        for(int i=1; i<nums.length; i++){
            System.out.println("i: "+i);
            for(int j=0; j<i; j++){
                System.out.println("nums["+j+"] "+nums[j]+" nums["+i+"] "+nums[i]);

                if(nums[j]<nums[i]){
                    System.out.println(" dp["+j+"] "+dp[j]+"   dp["+i+"]"+dp[i]);
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                    System.out.println("adp["+j+"]+1 "+dp[j]+" dp["+i+"]"+dp[i]);
                }
            }
            System.out.println();
            result=Math.max(result, dp[i]);
            System.out.println("result: "+result);
        }
        return result;

    }
}
