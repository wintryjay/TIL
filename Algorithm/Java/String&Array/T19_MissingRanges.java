package Algorithm.Java.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/*
# Question20. Missing Ranges(구간 나누기)
    Eng:
    Kor: 배열에 없는 구간을 찾아 보여주는 문제

    input:
        int[] nums = {2,3,5,50,75};
        int lower = 0, upper = 99;
    output:
        [0->1, 4, 6->49, 51->74, 76->99]

    ## solution)
     * 구간을 나눈다.
       1. 0<2 : lower < nums[0]
       2. 2 3, 3 5 nums[i]+1 < nums[i+1]
          2~3인 경우) pass,
          3~5인 경우) 4, 3+1 = 5-1, nums[i]+1, nums[i+1]-1
       3. 75 < 99 nums[nums.length-1] < upper
          76 < 99 nums[nums.length-1]+1, upper

 */
public class T19_MissingRanges {

    public static void main(String[] args) {
        int[] nums = {2,3,5,50,75};
        int lower= 0, upper = 99;
        System.out.println(solve(nums, lower, upper));
//        [0->1, 4, 6->49, 51->74, 76->99]
    }
    public static List<String> solve(int[] nums, int lower, int upper) {
        // 1. 그릇만들고, null 체
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        // 2-1. 구간 만들기
        if(lower < nums[0]) {
            result.add(makeRange(lower, nums[0]-1));
        }

        // 2-2.
        for(int i=0; i< nums.length-1;i++) {
            if(nums[i]!=nums[i+1] && nums[i]+1 < nums[i+1]) {
                result.add(makeRange(nums[i]+1, nums[i+1]-1));
            }
        }

        // 2-3.
        if(nums[nums.length-1] < upper) {
            result.add(makeRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }
    public static String makeRange(int low, int high) {
        return low==high ? String.valueOf(low) : (low+"->"+high);
    }


}
