package com.mukundmadhav.springboot.springboot;

public class JianZhiOffer {
    public static void main(String[] args) {
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
