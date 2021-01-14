package Algorithm.BackTracking;
/*
# Question03. Subsets(부분집합, DFS, List, Permutation)
    Eng: Given an integer array nums, return all possible subsets (the power set).
         The solution set must not contain duplicate subsets.
    Kor: 정수 배열 번호가 지정된 경우 가능한 모든 하위 집합(전원 집합)을 반환합니다.
         솔루션 세트에는 중복된 하위 집합이 없어야 합니다.

    input:
        nums = [1,2,3]
    output:
        output = [[3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]
 */
import java.util.ArrayList;
import java.util.List;

public class T03_Subsets {

    public static void main(String[] args) {
        T03_Subsets a = new T03_Subsets();
        int[] nums = {1,2,3};

        System.out.println(a.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        dfs(result, list, nums, 0);

        return result;
    }
    private void dfs(List<List<Integer>> lists, List<Integer> cur,int[] nums, int start) {
        //1 담는거

        List<Integer> list = new ArrayList<>(cur);
        lists.add(list);


        //2 for 저장, 탈출
        for(int i=start; i<nums.length; i++) {

            cur.add(nums[i]);
            dfs(lists, cur, nums,i+1 );
            cur.remove(cur.size()-1);
        }
    }
}
