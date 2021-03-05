package com.mukundmadhav.springboot.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JianZhiO {
    public static void main(String[] args) {

//        System.out.println(lengthOfLongestSubstring("abcabefgh"));
        System.out.println(replaceSpace(" ab ca bef gh "));
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    class TreeNode {
        int i;
        TreeNode left;
        TreeNode right;

        TreeNode(int i) {
            this.i = i;
        }
    }

    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(str, index + 1, ans, no);
        String yes = path + String.valueOf(str[index]);
        process1(str, index + 1, ans, yes);
    }

    public static int lengthOfLongestSubstring(String inputString) {
        if (inputString.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        String str = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (map.containsKey(inputString.charAt(i))) {
                left = Math.max(left, map.get(inputString.charAt(i)) + 1);
            }
            map.put(inputString.charAt(i), i);
            if (i - left + 1 > max) {
                str = inputString.substring(left, i + 1);
            }
            max = Math.max(max, i - left + 1);
        }
        System.out.println(str);
        return max;

    }

    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] newchars = new char[chars.length * 3];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                newchars[j++] = '%';
                newchars[j++] = '2';
                newchars[j++] = '0';
            } else {
                newchars[j++] = chars[i];
            }
        }

        return new String(newchars, 0, j);
    }

    public static void main1(String[] args) {
        int[] nums = {3, 1, 0, 4, 2};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
        System.out.println(nums);
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
