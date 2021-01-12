package Algorithm.Java.StringAndArray;

import java.util.*;

/*
# Question17. Group Anagrams(Array, List, Map)
    Eng: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
         An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
         typically using all the original letters exactly once.
    Kor: 문자열의 배열이 주어지면, 아나그램을 함께 그룹화합니다. 어떤 순서로든 답안을 돌려드릴 수 있습니다.
         아나그램은 다른 단어나 구문의 글자를 재정렬하여 형성된 단어나 구문으로, 일반적으로 모든 원래 문자를 정확히 한 번 사용합니다.

    input:
        ["eat", "tea", "tan", "ate", "nat", "bat"]
    output:
        [["ate", "eat", "tea"],
        ["nat","tan"],
        ["bat"]]
 */
public class T16_GroupAnagrams {

    public static void main(String[] args) {
         String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 1.
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();

        //2.
        for(String str : strs) {
            System.out.println("str:" + str);
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            System.out.println("char:" +charArray);
            String key = String.valueOf(charArray);
            System.out.println("key:"+ key);

            if(map.containsKey(key)) {
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
