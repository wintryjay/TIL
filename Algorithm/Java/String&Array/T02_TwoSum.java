package Algorithm.Java.StringAndArray;

/*
# Question03. TwoSum (Map, Array)
    Eng: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
          You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Kor: 정수의 배열이 지정된 경우 두 숫자의 인덱스가 특정 대상에 추가되도록 합니다.
          각 입력에 정확히 하나의 솔루션이 있다고 가정할 수 있으며, 동일한 요소를 두 번 사용하지 않을 수도 있습니다.

    input: int[] nums = {2, 8, 11, 21};
           int target = 10;
    output: int[] = {1, 2}

# Flow
    1. 문제를 정확하게 이해한다.
    2. 알고리즘을 정하고 담을 그릇을 정한다.
    3. for문을 돌린다.

# TIP) 문제 적용 3단계(한국어로 문제완전히해 + 데이터 그릇만들기 + for문 돌리기 + 알고리즘 적용하기)
    - 한국말로 쓰고, 프로그램(Java)화 시키자.
    - nums array의 index를 0부터 for문으로 돌려서 2가 나오면 10에서 2를 뺐을 때, 8이 나올 경우, 맵에 8을 등록(8, 1)하고
      다음 index를 돌려서 맵에 있는 것과 매치가 되면 index를 구할 수 있다.
    1. 2와 8을 꺼낸다.
    2. 10인지 확인한다.
    3. 10-2를 한다.
    4. 8을 찾아낸다.
 */


import java.util.HashMap;
import java.util.Map;

public class T02_TwoSum {

    public static void main(String[] args) {
        // 1. 예제의 Input 값을 넣어 인자를 만들어준다.
        int[] nums = {2, 8, 11, 21};
        int target = 10;

        // 2. 객체를 새로 만들어서 위에서 인자값으로 받는 메서드를 결과값으로 넣어준다.
        T02_TwoSum a = new T02_TwoSum();
        int[] result = a.solve(nums, target);
    }

        // 3. 문제를 풀어줄 메서드를 만들어준다.
    public int[] solve(int[] nums, int target) {

        // 5. 4번을 하기 위해서 담을 그릇을 만들어 준다.
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        // 4. for문을 돌려준다.
        for(int i=0; i<nums.length; i++){

        }
        return nums;
    }

    public int[] twoSum(int[] nums, int target){

    }
}
