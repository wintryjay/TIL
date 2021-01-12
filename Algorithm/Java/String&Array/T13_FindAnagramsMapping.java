package Algorithm.Java.StringAndArray;

import java.util.HashMap;
import java.util.Map;

/*
# Question14. Find Anagrams Mapping(Map)
    input:
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
    output:
        [1 4 3 2 0]

    1. Map을 이용한다. Key, Value 를 이용
    2. Array B의 순서를 리턴
    3. 반환값 : int[]
    4. Map A의 값을 셋팅
    5. 꺼낼때는 B key 값으로 리턴된 걸 int[]
 */
public class T13_FindAnagramsMapping {
    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = anagramMappings(A, B);
        print(result);
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        // 1.
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        // 2.
        for(int i=0; i<A.length; i++) {
            map.put(B[i], i); // 1 4 3 2 0
        }
        for(int i=0; i<A.length; i++) {
            result[i] = map.get(A[i]); // 1 4 3 2 0
        }
        return result;
    }

    public static void print(int[] result) {
        for(int i = 0; i<result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}
