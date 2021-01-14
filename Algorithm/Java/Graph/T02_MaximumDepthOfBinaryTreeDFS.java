package Algorithm.Graph;
/*
# Question02. Maximum Depth Of Binary Tree(Stack, DFS)

    Eng: Given the root of a binary tree, return its maximum depth.
         A binary tree's maximum depth is the number of nodes along the longest path
         from the root node down to the farthest leaf node.

    Kor: 이진 트리의 루트가 지정된 경우 최대 깊이를 반환합니다.
         이진 트리의 최대 깊이는 루트 노드에서 가장 먼 리프 노드까지의 가장 긴 경로를 따르는 노드 수입니다.

    ## Solution)
    1. DFS방식 스택을 이용한다.
        * 계산기문제, 스코어계산, 가로에 대한 계산 등 상대방이 있거나, 순서 방식을 체크해야하는것에 DFS 사용
 */


import java.util.Stack;

public class T02_MaximumDepthOfBinaryTreeDFS {

    public static void main(String[] args) {
        T02_MaximumDepthOfBinaryTreeDFS a =new T02_MaximumDepthOfBinaryTreeDFS();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        System.out.println("val: "+a.dfs(node));
    }

    public int dfs(TreeNode root) {
        // 1.
        if(root == null) return 0;
        Stack<TreeNode> stack =new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = Math.max(max, count);

            if(node.left != null) {
                stack.push(node.left);
                valueStack.push(1+count);
            }
            if(node.right != null) {
                stack.push(node.right);
                valueStack.push(1 + count);
            }
        }
        return max;
    }
}
