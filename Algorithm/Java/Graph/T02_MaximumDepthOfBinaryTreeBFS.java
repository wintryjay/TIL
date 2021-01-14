package Algorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
# Question02. Maximum Depth Of Binary Tree(Queue, BFS)

    Eng: Given the root of a binary tree, return its maximum depth.
         A binary tree's maximum depth is the number of nodes along the longest path
         from the root node down to the farthest leaf node.

    Kor: 이진 트리의 루트가 지정된 경우 최대 깊이를 반환합니다.
         이진 트리의 최대 깊이는 루트 노드에서 가장 먼 리프 노드까지의 가장 긴 경로를 따르는 노드 수입니다.

    ## Solution)
    1. Queue 방식 근접해서 한칸씩
    2.

 */
public class T02_MaximumDepthOfBinaryTreeBFS {

    public static void main(String[] args) {
        T02_MaximumDepthOfBinaryTreeBFS a =new T02_MaximumDepthOfBinaryTreeBFS();

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);

        System.out.println(a.bfs(tree));
    }

    public int bfs(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right !=null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}
