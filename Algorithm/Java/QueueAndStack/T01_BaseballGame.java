package Algorithm.QueueAndStack;

import java.util.Stack;

/*
# Question01. Baseball Game(Stack, Switch case, Operation)
    Eng: You are keeping score for a baseball game with strange rules.
         The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
         At the beginning of the game, you start with an empty record.
         You are given a list of strings ops, where ops[i] is the ith operation you must apply to
         the record and is one of the following:

        1. An integer x - Record a new score of x.
        2. "+" - Record a new score that is the sum of the previous two scores.
            It is guaranteed there will always be two previous scores.
        3. "D" - Record a new score that is double the previous score.
            It is guaranteed there will always be a previous score.
        4. "C" - Invalidate the previous score, removing it from the record.
            It is guaranteed there will always be a previous score.

        Return the sum of all the scores on the record.

    Kor: 당신은 이상한 규칙들로 야구경기 점수를 유지하고 있군요. 이 게임은 몇 개의 라운드로 구성되어 있으며,
         이 라운드에서 과거 라운드의 점수가 향후 라운드의 점수에 영향을 미칠 수 있습니다.
         게임을 시작할 때 빈 기록으로 시작합니다. 문자열 ops 목록이 주어지며, 여기서 ops[i]는 레코드에 적용해야 하는 i번째 작업이며 다음 중 하나입니다.

        1. 정수 x - 새로운 x 점수를 기록합니다.
        2. "+" - 이전 두 점수의 합계인 새 점수를 기록합니다. 항상 두 개의 이전 점수가 있을 것이라고 보장된다.
        3."D" - 이전 점수의 두 배인 새 점수를 기록합니다. 항상 이전 점수가 있을 것이라고 보장한다.
        4. "C" - 이전 점수를 무효화하고 레코드에서 제거합니다. 항상 이전 점수가 있을 것이라고 보장한다.

        레코드에 있는 모든 점수의 합계를 반환합니다.

    input:
        input: ["5", "-2", "4", "C", "D", "9", "+", "+"]
    output: 27

    ## Solution)
    1. The sum is : 5
    2. -2 points, The sum is : 3
    3. 4 points, The sum is : 7
    C: 3번 데이터 삭제, The sum is: 3
    D: 2번의 -2값 더블 -4 를 얻음, -4+3 = -1, The sum is : -1
    5. 9 points, The sum is : 8
    6. -4 + 9 = 5 points. The sum is : 13
    7. 9 + 5 = 14 points. The sum is : 27
 */
public class T01_BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(points(strs));
    }

    public static int points(String[] strs) {
        // 1.
        Stack<Integer> stack = new Stack<>();

        // 2.
        for(String op : strs) {
            switch (op) {
                case "C" :
                    stack.pop();
                    break;
                case "D" :
                    stack.push(stack.peek()*2);
                    break;
                case "+" :
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum+=stack.pop();
        }
        return sum;
    }
}
