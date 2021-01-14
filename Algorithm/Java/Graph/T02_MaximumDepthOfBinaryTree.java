package Algorithm.Graph;
/*
# Question02. Maximum Depth Of Binary Tree(Stack, Recursive)

    Eng: Given the root of a binary tree, return its maximum depth.
         A binary tree's maximum depth is the number of nodes along the longest path
         from the root node down to the farthest leaf node.

    Kor: 이진 트리의 루트가 지정된 경우 최대 깊이를 반환합니다.
         이진 트리의 최대 깊이는 루트 노드에서 가장 먼 리프 노드까지의 가장 긴 경로를 따르는 노드 수입니다.

    ## Solution)
    1. left, right 를 호출한다.
    2. Math.max(leftMax, rightMax) 를 이용한다.
 */
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
}
public class T02_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);

        T02_MaximumDepthOfBinaryTree a = new T02_MaximumDepthOfBinaryTree();
        System.out.println(a.maxDepth(tree));
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        System.out.println(root.val);
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax)+1; // 1. 7일때, 양쪽이 null 일때 +1,
                                              // 2. 5 에서는, 1+1 = 2
                                              // 3. 1 일때는, 2+1 = 3
    }
}
