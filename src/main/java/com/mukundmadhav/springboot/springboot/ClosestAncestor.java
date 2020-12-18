package com.mukundmadhav.springboot.springboot;

/**
 * @author 周东亮
 * @description 查找二叉树里两个节点的公共祖先
 */
public class ClosestAncestor {

    /**
     * 测试主函数
     */
    public static void main(String[] args) {
        /**
         * 创建一个二叉树
         *    0
         *  1   2
         * 3 4 5 6
         */
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 选两个测试节点用例
        TreeNode nodeA = root.right.left;
        TreeNode nodeB = root.right.right;

        // 查找
        TreeNode closestCommonAncestor = findClosestCommonAncestor(root, nodeA, nodeB);

        // 打印结果
        System.out.println(null == closestCommonAncestor ? "空" : "公共祖先的值为：" + closestCommonAncestor.val);
    }

    /**
     * 查找二叉树里节点A和B最近的公共祖先
     *
     * @param root  二叉树
     * @param nodeA 节点A
     * @param nodeB 节点B
     * @return 祖先
     */
    public static TreeNode findClosestCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
        // 按前序遍历为例
        // 非法数据判断：如果传入的树为空，则直接返回空
        if (root == null) {
            return null;
        }
        // 边界数据判断：如果传入的两节点是根，则直接返回根
        if (root == nodeA || root == nodeB) {
            return root;
        }
        // 左子树查找
        TreeNode left = findClosestCommonAncestor(root.left, nodeA, nodeB);
        // 右子树查找
        TreeNode right = findClosestCommonAncestor(root.right, nodeA, nodeB);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // 左右子树都不为空
            return root;
        }
    }


    /**
     * 二叉树定义
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
