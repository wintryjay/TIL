package Algorithm.QueueAndStack;

import java.util.Stack;

/*
# Question02. Valid Parentheses(Stack, Map, Switch case)
    Eng: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
         if the input string is valid.
         An input string is valid if:
         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

    Kor: 문자열 '(, '), '{, '}, '[' 및 ']' 문자만 포함하는 문자열을 지정하면 입력 문자열이 유효한지 확인하십시오.
         다음과 같은 경우 입력 문자열이 유효합니다.
         1. 열린 브래킷은 동일한 유형의 브래킷으로 닫아야 합니다.
         2. 열린 브래킷은 올바른 순서로 닫혀 있어야 합니다.

    input:
        "{[]}"
    output:
        true
    input:
        "([)]"
    output:
        false

    ## Solution)
    1. 오픈 가로들을 먼저 스택에 넣는다.
    2. 클로즈 가로들이 나오면 뺀다.
    3. 최종으로 stack이 남아있는지 체크한다.
 */
public class T02_ValidParentheses {

    public static void main(String[] args) {

        String exp1 = "()[]{}";
        String exp2 = "([)]";
        System.out.println(isValid(exp1));
        System.out.println(isValid(exp2));
    }

    public static boolean isValid(String s) {
        // 1. Error Check, 그릇 만들기
        if(s.length()%2 !=0 )
            return false;
        Stack<Character> stack = new Stack<>();

        // 2.
        for(int i=0; i<s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if(!stack.empty() && stack.peek()=='(')
                        stack.pop();
                    break;
                case '}':
                    if(!stack.empty() && stack.peek()=='{')
                        stack.pop();
                    break;
                case ']':
                    if(!stack.empty() && stack.peek()=='[')
                        stack.pop();
                    break;
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }
}
