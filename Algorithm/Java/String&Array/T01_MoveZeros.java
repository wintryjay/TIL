package Algorithm.Java.StringAndArray;

/*
# Question02. MoveZeros (Array)
    Eng: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Kor: 배열 num을 감안할 때 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하시오.

    Input: [0, 3, 2, 0, 8, 5]
    Output: [3, 2, 8, 5, 0, 0]

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

# Flow
    1. 값이 0이 아닌 값을 먼저 array에 담는다.
    2. Index를 기억한다.
    3. 해당 Index 0인 값을 넣는다.

    ** Array의 개념을 알고, Array의 Index를 조작하는 방법을 알아야 하는 문제 **
*/

public class T01_MoveZeros {

    public static void main(String[] args) {
        // 1. 제시한 예제를 먼저 넣어주고 인덱스를 초기화 해준다.
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;

        // 2. for문을 통해 각각의 원소가 0이 아닌 값을 새롭게 인덱스로 정렬시켜준다.
        // nums = {3, 2, 8, 5}
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
                System.out.println("//2 index "+index);
            }
        }

        // 3. while문을 통해서 인덱스가 3보다 크고 6보다 작은 즉, 4와 5에는 0값을 넣어준다.
        while(index< nums.length){
            nums[index]=0;
            index++;
            System.out.println("//3 index "+index);
        }

        // 4. 테스트 확인
        for(int i=0; i< nums.length; i++){
            System.out.println(nums[i]);
        }
    }

}
