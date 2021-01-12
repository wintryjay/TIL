package Algorithm.Java.StringAndArray;
/*
# Question18. Trapping Rain Water(Case이해, Math.min)
    Eng: Given n non-negative integers representing an elevation map where the width of each bar is 1,
         compute how much water it can trap after raining.
    Kor: 각 막대의 너비가 1인 표가 주어지고, 지도를 나타내는 음이 아닌 정수가 n개 있으면 비가 온 후 물을 얼마나 가두어 놓을 수 있는지 계산한다.

    input:
//        int[] left  = {0,1,1,2,2,2,2,3,3,3,3,3};
//        int[] right = {3,3,3,3,3,3,3,3,2,2,2,1};
//        Math.min    = {0,1,1,2,2,2,2,3,2,2,2,1};
          Height      = {0,1,0,2,1,0,1,3,2,1,2,1}; <- 주어진 값
//                       0,0,1,0,1,2,1,0,0,1,0,0
    output: 6

    ## Case)
    1) 물을 부었을 때, 높이 2 : 왼쪽 벽 2, 오른쪽벽 3, 작은값 2
    2) 물을 부었을 때, 높이 1: 왼쪽 벽 2, 오른쪽벽 3, 작은값 2 - 자체높이 1 = 1

 */
public class T17_TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solve(nums));
    }

    public static int solve(int[] height) {
        // 1.
        int result = 0;
        if(height==null || height.length <=2) return result;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        // 2. left, right 구해줘야 한다.
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i< height.length; i++) {
            if(max < height[i]) {
                left[i] = height[i];
                max = height[i];
            }else {
                left[i] = max;
            }
        }

        // 3. right
        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];

        for (int i= height.length-2; i>=0; i--) {
            if (max<height[i]) {
                right[i] = height[i];
                max = height[i];
            }else {
                right[i] = max;
            }
        }

        // 4. Math.Min 구함
        for(int i=0; i< height.length; i++) {
            result += Math.min(left[i], right[i])-height[i];
        }

        return result;

    }
}
