package Algorithm.DynamicProgramming;
/*
# Question03. ClimbingStairs
    Eng: You are climbing a staircase. It takes n steps to reach the top.
         Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Kor: 너는 계단을 오르고 있다. 정상에 도달하는 데 단계가 걸린다.
         매번 당신은 한두 계단을 오를 수 있다. 얼마나 많은 뚜렷한 방법으로 정상에 오를 수 있나요?

    input: 3

    output: 3

    ## solution)
    1. dp[3] = dp[2] + dp[1]
       dp[i] = dp[i-1] + dp[i-2]
 */
public class T03_ClimbingStairs {

    public static void main(String[] args) {
        int n =5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }

}
