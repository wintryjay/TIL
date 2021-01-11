/*
# Question 04. DailyTemperature (Stack)
  Eng: Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
       If there is no future day for which this is possible, put 0 instead.
  Kor: 일별 온도 T 목록을 지정한 경우 입력의 각 요일에 대해 온도가 따뜻해질 때까지 며칠을 기다려야 하는지 알려주는 목록을 반환합니다.
       만약 가능한 날이 없으면, 0을 반환하게 합니다.
       
  input: int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73}
  output: 1 1 4 2 1 1 0 0
*/

package Algorithm.Java.StringAndArray;

import java.util.Stack;

public class T03_DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(nums);

        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    public static int[] dailyTemperatures(int[] temper){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        for (int i=0; i<temper.length; i++){
            while(!stack.isEmpty() && temper[stack.peek()]<temper[i]) {
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }
        return result;
    }
}
