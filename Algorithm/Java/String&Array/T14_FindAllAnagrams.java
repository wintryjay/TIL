package Algorithm.Java.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/*
#Question15. Find All Anagrams어
    Eng:
    Kor: 순서가 바뀌는 영어, 대칭적인 패턴적 문제

    input:
        String txt = "BACDGABCDA";
        String pat = "ABCD";
    output:
        [0, 5, 6]

    1. 패턴: ABCD값을 아스키값 Array에 담는다. 65, 66, 67, 68(고유키값)
    2. 대상소스(txt)를 비교한다. 이중 for문으로
    3. txt, pat을 같은지 비교한다.
 */
public class T14_FindAllAnagrams {

    public static void main(String[] args) {
        T14_FindAllAnagrams a = new T14_FindAllAnagrams();
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(a.findAnagrams(txt,pat));
    }

    public List<Integer> findAnagrams(String txt, String pat) {
        // 1.
        List<Integer> result = new ArrayList<>();
        if(txt==null || txt.length() ==0 || pat==null || pat.length()==0 || txt.length()<pat.length())
            return result;

        // 2.
        int[] patArr = new int[256];
        for(int i=0; i<pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }

        for(int i = 0; i < txt.length()-pat.length()+1; i++) {
            int[] txtArr = new int[256];
            for(int j=0; j<pat.length(); j++) {
                txtArr[txt.charAt(i+j)]++;
            }

            if(check(patArr, txtArr)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean check(int[] patArr, int[] txtArr) {
        for(int i=0; i<patArr.length; i++) {
            if(patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }

}
