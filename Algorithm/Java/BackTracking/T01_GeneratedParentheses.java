package Algorithm.BackTracking;
/*
# Question01. GeneratedParentheses(DFS)
    DFS: 깊게 파고들어서 모든 경우의 수를 다 찾는
    Eng: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Kor: 괄호 쌍이 n개 있으면 잘 구성된 괄호의 모든 조합을 생성하는 함수를 작성합니다.

    input:
        n = 3
    output:
        [((())), (()()), (())(), ()(()), ()()()]
 */
import java.util.ArrayList;
import java.util.List;

public class T01_GeneratedParentheses {

    public static void main(String[] args) {
        T01_GeneratedParentheses a = new T01_GeneratedParentheses();
//		System.out.println(a.generateParenthesis_backTrac(3));
        System.out.println(a.generateParenthesis_dfs(3));
    }

    int count =0;
    public List<String> generateParenthesis_dfs(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n,"");
        return res;
    }

    private void dfs(List<String> list, String str, int left, int right, String str1) {
        count++;
        System.out.println("str\t"+str+"\t left: "+left+" right: "+right+" count: "+count+" str1: "+str1);
        // 1
        if (left < 0 || left > right) {
            return;
        }

        // 2
//	        System.out.println("str: "+str);
//        System.out.println("=str\t"+str+"\t left: "+left+" right: "+right+" count: "+count);
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        dfs(list, str + '(', left - 1, right, str1+"+");
        dfs(list, str + ')', left, right - 1, str1+"-");
    }
}
