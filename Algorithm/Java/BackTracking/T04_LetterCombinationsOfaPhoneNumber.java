package Algorithm.BackTracking;
/*
# Question04. Letter Combination(2for)
    Eng: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
         could represent. Return the answer in any order.
         A mapping of digit to letters (just like on the telephone buttons) is given below.
         Note that 1 does not map to any letters.

    Kor: 2-9자리의 숫자가 포함된 문자열을 지정하면 숫자가 나타낼 수 있는 가능한 모든 문자 조합을 반환합니다. 어떤 순서로든 답을 돌려주세요.
         숫자 대 문자 매핑(전화 버튼과 동일)은 아래에 나와 있습니다. 1은 어떤 문자에도 매핑되지 않습니다.

    input:
        String digits = "23"
    output:
        ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
import java.util.ArrayList;
import java.util.List;

public class T04_LetterCombinationsOfaPhoneNumber {

    public static void main(String[] args) {
        T04_LetterCombinationsOfaPhoneNumber a = new T04_LetterCombinationsOfaPhoneNumber();
        a.solve("23");
    }

    public List<String> solve(String digits) {
        String digitletter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            combine(result, digitletter[digits.charAt(i) - '0']);
        }
        return result;
    }

    public List<String> combine(List<String> firstList, String digit) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++) {
            for (String firstStr : firstList) {
                result.add(firstStr + digit.charAt(i));
            }
        }
        return result;
    }
}
