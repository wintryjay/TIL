package Algorithm.DynamicProgramming;
/*
# Question02. Coin Change(DP)
    DP : 답을 알고 그 전 단계를 파는 것
    Eng: You are given coins of different denominations and a total amount of money amount.
         Write a function to compute the fewest number of coins that you need to make up that amount.
         If that amount of money cannot be made up by any combination of the coins, return -1.
         You may assume that you have an infinite number of each kind of coin.
    Kor: 다른 액면가의 동전과 총금액이 주어집니다.
         해당 금액을 구성하는 데 필요한 동전 수를 가장 적게 계산하는 함수를 작성합니다.
         만약 그 돈의 액수가 어떤 조합으로도 만들어 질 수 없다면, -1로 돌려주세요.
         여러분은 각 종류의 동전을 무한정 가지고 있다고 가정할 수 있습니다.

    input:
        coins = [1, 2, 5]
        amount = 11
    output:
        3 (11 = 5+ 5+ 1)

 */
import java.util.Arrays;

public class T02_CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }


    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            System.out.println("i: "+i);
            for (int j = 0; j < coins.length; j++) {
                System.out.println(": "+coins[j]+"  "+i);
                if (coins[j] <= i) {
                    System.out.println("coins["+j+"]"+coins[j]+" i "+i+" "+(dp[i - coins[j]]));
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println();
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
