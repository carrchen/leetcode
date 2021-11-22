package com.example.demo.algorithm.num75_SortColors;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 */
public class Solution {

    public void sortColors(int[] nums) {
        int[] tem = new int[3];
        for (int num : nums) {
            tem[num]++;
        }
        int index = 0;
        for (int i = 0; i < tem.length; i++) {
            for (int i1 = 0; i1 < tem[i]; i1++) {
                nums[index++] = i;
            }
        }
    }


    public static void sortColors2(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;

        while (i <= two) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,0,1,0};
        sortColors2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
