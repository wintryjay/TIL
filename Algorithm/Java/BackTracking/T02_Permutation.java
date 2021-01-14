package Algorithm.BackTracking;
/*
# Question02. Permutation(퍼뜨리다. 순열, DFS, List)
    Eng: Given an array nums of distinct integers, return all the possible permutations.
         You can return the answer in any order.
    Kor: 고유 정수의 배열 수가 지정된 경우 가능한 모든 순열을 반환합니다. 어떤 순서로든 답안을 돌려드릴 수 있습니다.열

    input:
        [1,2,3]
    output:
        [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]

 */
import java.util.ArrayList;
import java.util.List;

public class T02_Permutation {

    public static void main(String[] args) {
        T02_Permutation a = new T02_Permutation();
        int[] nums = {1,2,3};
//		System.out.println(a.permute_backTrack(nums));
        System.out.println(a.permute_dfs(nums));
    }

    public List<List<Integer>> permute_dfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        dfs(nums, result, list);
        return result;
    }
    int count=0;
    private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
        count++;
        System.out.println("--start--"+cur);

        // 1. 담는 것
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        // 2. for 탈출
        for (int i = 0; i < nums.length; i++) {

            if (cur.contains(nums[i])) {

                continue;
            }
//	        if (cur.size() == nums.length) {
//        	continue;
//	    }
            System.out.println("========i: "+i+" nums[" + i + "]=" + nums[i]+" cur: "+cur+" count "+count);
            cur.add(nums[i]);
//	        System.out.println("########i: "+i+" nums[" + i + "]=" + nums[i]+" cur: "+cur+" count "+count);
            dfs(nums, lists, cur);
            System.out.println("size = " + cur.size());
            cur.remove(cur.size() - 1);
        }

        System.out.println("--end--"+cur);
        System.out.println();
    }

}
