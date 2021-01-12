package Algorithm.Java.StringAndArray;

import java.util.HashMap;
import java.util.Map;

/*
# Qestion12. LongestSubstringWithAtMostTwoDistinct(Map, two Pointer, Math.max)
    Eng: Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
    Kor: 주어진 문자열에서 최대 2개의 고유 문자를 포함하는 가장 긴 하위 문자열의 길이를 찾습니다.

    input: String s = "ccaabbb"
    output: 5

    1. End-Start 로 비교한 값을 length에 답는다.
    2. 문자를 2개를 인식하기 위해서 Counter로 담는다. 이때, counter는 Map
 */
public class T11_LongestSubstringWithAtMostTwoDistinct {

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        // 1.
        int start = 0, end =0, length = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        // 2.
        while(end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0)+1);// c=2, a=2, b=3
            if(map.get(endChar)==1) counter++;
            end++;

            // 3.
            while (counter > 2) {
               char startChar = s.charAt(start);
               map.put(startChar, map.get(startChar)-1);

               if(map.get(startChar)==0) counter--;

               start++;
            }
            length = Math.max(length, end-start);
        }
        return length;
    }

}
