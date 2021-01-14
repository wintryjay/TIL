package Algorithm.Graph;

import java.util.*;

/*
# Question06. Remove Invalid Parentheses(BFS, Queue, substring)

    Eng: Remove the minimum number of invalid parentheses in order to make the input string valid.
         Return all possible results.
         Note: The input string may contain letters other than the parentheses ( and ).

    Kor: 입력 문자열을 유효하게 만들려면 잘못된 최소 괄호 수를 제거하십시오. 가능한 모든 결과를 반환합니다.
         참고: 입력 문자열에는 괄호( 및 ) 이외의 문자가 포함될 수 있습니다.

    input:
        "(a)())()"
    output:
        ["(a)()()", "(a())()"]
    input:
        "()())()"
    output:
        ["()()()", "(())()"]

    ## solution)
    1. Queue에 저장
    2. 케이스별로 valid 체크
    3. Brace 체크, 쌍으로 존재
    4. newStr 큐에 저장
    ex) 012345
    substring(0,3): 012
    substring(3): 345
 */
public class T06_RemoveInvalidParentheses {

    public static void main(String[] args) {
        String s = "(a)())()";
        T06_RemoveInvalidParentheses a = new T06_RemoveInvalidParentheses();
        System.out.println(a.solve(s));
    }

    public List<String> solve(String s) {
        List<String> result = new ArrayList<>();
        if (s == null)
            return result;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    found = true;
                    System.out.println("str: " + str + " found " + found);
                }
                System.out.println("found " + found);
                if (found) continue;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    System.out.println(str.substring(0, j) + ":" + str.substring(j + 1));
                    String newStr = str.substring(0, j) + str.substring(j + 1);
                    if (!visited.contains(newStr)) {
//						System.out.println("newStr: "+newStr);
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
                System.out.println("======");
            }
        }
        return result;
    }

    private boolean isValid(String str) {
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}

