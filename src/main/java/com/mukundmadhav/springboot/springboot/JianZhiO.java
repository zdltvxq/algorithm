package com.mukundmadhav.springboot.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JianZhiO {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabefgh"));
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
            if(i - left + 1 > max){
                str = inputString.substring(left, i+1);
            }
            max = Math.max(max, i - left + 1);
        }
        System.out.println(str);
        return max;

    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (' ' == chars[i]) {
                //chars[i] = "%20";
            }
        }
        for (char aChar : chars) {


            if (' ' == aChar) {

            }
        }
        return null;
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
